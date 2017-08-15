package com.chenxi.zookeeper.mastersel;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkException;
import org.I0Itec.zkclient.exception.ZkInterruptedException;
import org.I0Itec.zkclient.exception.ZkNoNodeException;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WorkServer {

	private volatile boolean running = false;

	private ZkClient zkClient;

	private static final String MASTER_PATH = "/master";

	private IZkDataListener dataListener;

	private RunningData serverData;

	private RunningData masterData;

	private ScheduledExecutorService delayExector = Executors.newScheduledThreadPool(1);
	private int delayTime = 5;

	public WorkServer(RunningData rd) {
		this.serverData = rd;
		this.dataListener = new IZkDataListener() {
			public void handleDataDeleted(String dataPath) throws Exception {
				// takeMaster();
				// 适应网络抖动
				// 若之前master为本机,则立即抢主,否则延迟5秒抢主(防止小故障引起的抢主可能导致的网络数据风暴)
				if (masterData != null && masterData.getName().equals(serverData.getName())) {
					takeMaster();
				} else {
					delayExector.schedule(new Runnable() {
						public void run() {
							takeMaster();
						}
					}, delayTime, TimeUnit.SECONDS);
				}
			}

			public void handleDataChange(String dataPath, Object data) throws Exception {

			}
		};
	}

	public ZkClient getZkClient() {
		return zkClient;
	}

	public void setZkClient(ZkClient zkClient) {
		this.zkClient = zkClient;
	}

	/**
	 * 启动订阅master节点，然后抢master节点
	 *
	 * @throws Exception
	 */
	public void start() throws Exception {
		if (running) {
			throw new Exception("server has startup...");
		}
		running = true;
		zkClient.subscribeDataChanges(MASTER_PATH, dataListener);

		takeMaster();
	}

	public void stop() throws Exception {
		if (!running) {
			throw new Exception("server has stoped");
		}
		running = false;

		delayExector.shutdown();

		zkClient.unsubscribeDataChanges(MASTER_PATH, dataListener);

		releaseMaster();

	}

	private void takeMaster() {
		if (!running)
			return;
		try {
			// 创建临时节点，session连接失败自动删除
			zkClient.create(MASTER_PATH, serverData, CreateMode.EPHEMERAL);
			masterData = serverData;
			System.out.println(serverData.getName() + " is master");

			// 测试使用，每5秒释放master节点
			delayExector.schedule(new Runnable() {
				public void run() {
					if (checkMaster()) {
						releaseMaster();
					}
				}
			}, delayTime, TimeUnit.SECONDS);
		} catch (ZkNodeExistsException e) {
			//如果master节点已经存在读取
			RunningData runningData = zkClient.readData(MASTER_PATH, true);

			//数据为空说明此时master宕机
			if (runningData == null) {
				takeMaster();
			} else {
				masterData = runningData;
			}
		} catch (Exception e) {
			// ignore;
		}
	}

	private void releaseMaster() {
		if (checkMaster()) {
			zkClient.delete(MASTER_PATH);
		}
	}

	private boolean checkMaster() {
		try {
			RunningData eventData = zkClient.readData(MASTER_PATH);
			masterData = eventData;
			if (masterData.getName().equals(serverData.getName())) {
				return true;
			}
			return false;
		} catch (ZkNoNodeException e) {
			return false;
		} catch (ZkInterruptedException e) {
			return checkMaster();
		} catch (ZkException e) {
			return false;
		}
	}

}
