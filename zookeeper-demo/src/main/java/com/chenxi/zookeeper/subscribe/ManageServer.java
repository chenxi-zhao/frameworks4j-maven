package com.chenxi.zookeeper.subscribe;

import com.alibaba.fastjson.JSON;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNoNodeException;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;

import java.util.List;

public class ManageServer {
	// 服务器集群节点地址
	private String serversPath;
	// 命令地址
	private String commandPath;
	// 配置信息存储地址
	private String configPath;

	private ZkClient zkClient;
	// 配置信息
	private ServerConfig config;
	// 集群子节点监听器，更新workServerList中的server
	private IZkChildListener childListener;
	// 命令监听器，监听命令节点数据发生变化并执行
	private IZkDataListener dataListener;
	private List<String> workServerList;

	public ManageServer(String serversPath, String commandPath, String configPath, ZkClient zkClient,
			ServerConfig config) {
		this.serversPath = serversPath;
		this.commandPath = commandPath;
		this.configPath = configPath;

		this.zkClient = zkClient;
		this.config = config;

		this.childListener = new IZkChildListener() {
			public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
				workServerList = currentChilds;
				System.out.println("work server list changed, new list is ");
				execList();
			}
		};
		this.dataListener = new IZkDataListener() {
			public void handleDataDeleted(String dataPath) throws Exception {
				// ignore;
			}

			public void handleDataChange(String dataPath, Object data) throws Exception {
				String cmd = new String((byte[]) data);
				System.out.println("cmd:" + cmd);
				exeCmd(cmd);

			}
		};

	}

	private void initRunning() {
		// 订阅命令节点
		zkClient.subscribeDataChanges(commandPath, dataListener);

		// 订阅服务器集群节点
		zkClient.subscribeChildChanges(serversPath, childListener);
	}

	/*
	 * 1: list 2: create 3: modify
	 */
	private void exeCmd(String cmdType) {
		if ("list".equals(cmdType)) {
			execList();
		} else if ("create".equals(cmdType)) {
			execCreate();
		} else if ("modify".equals(cmdType)) {
			execModify();
		} else {
			System.out.println("error command!" + cmdType);
		}

	}

	private void execList() {
		System.out.println(workServerList.toString());
	}

	private void execCreate() {
		if (!zkClient.exists(configPath)) {
			try {
				zkClient.createPersistent(configPath, JSON.toJSONString(config).getBytes());
			} catch (ZkNodeExistsException e) {
				zkClient.writeData(configPath, JSON.toJSONString(config).getBytes());
			} catch (ZkNoNodeException e) {
				String parentDir = configPath.substring(0, configPath.lastIndexOf('/'));
				zkClient.createPersistent(parentDir, true);
				execCreate();
			}
		}
	}

	private void execModify() {
		config.setDbUser(config.getDbUser() + "_modify");

		try {
			zkClient.writeData(configPath, JSON.toJSONString(config).getBytes());
		} catch (ZkNoNodeException e) {
			execCreate();
		}
	}

	/**
	 * 启动
	 */
	public void start() {
		initRunning();
	}

	public void stop() {
		zkClient.unsubscribeChildChanges(serversPath, childListener);
		zkClient.unsubscribeDataChanges(commandPath, dataListener);
	}
}
