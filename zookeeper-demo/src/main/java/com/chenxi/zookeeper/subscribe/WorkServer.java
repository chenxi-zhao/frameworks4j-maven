package com.chenxi.zookeeper.subscribe;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNoNodeException;

import com.alibaba.fastjson.JSON;

public class WorkServer {

	private ZkClient zkClient;
	// config配置信息路径
	private String configPath;
	// server服务器列表存储路径
	private String serversPath;
	// 当前服务器的基本信息
	private ServerData serverData;
	// 所管理的服务器集群配置信息，通过监听器监听修改
	private ServerConfig serverConfig;
	// 监控/config配置信息修改的监听器
	private IZkDataListener dataListener;

	public WorkServer(String configPath, String serversPath, ServerData serverData, ZkClient zkClient,
			ServerConfig initConfig) {
		this.zkClient = zkClient;
		this.serversPath = serversPath;
		this.configPath = configPath;
		this.serverConfig = initConfig;
		this.serverData = serverData;

		this.dataListener = new IZkDataListener() {
			public void handleDataDeleted(String dataPath) throws Exception {
				// TODO Auto-generated method stub
			}

			public void handleDataChange(String dataPath, Object data) throws Exception {
				// TODO Auto-generated method stub
				String retJson = new String((byte[]) data);
				ServerConfig serverConfigLocal = (ServerConfig) JSON.parseObject(retJson, ServerConfig.class);
				updateConfig(serverConfigLocal);
				System.out.println("new Work server config is:" + serverConfig.toString());

			}
		};

	}

	public void start() {
		System.out.println("work server " + serverData.getName() + " start...");
		initRunning();
	}

	public void stop() {
		System.out.println("work server " + serverData.getName() + " stop...");
		zkClient.unsubscribeDataChanges(configPath, dataListener);
	}

	private void initRunning() {
		registMe();
		zkClient.subscribeDataChanges(configPath, dataListener);
	}

	private void registMe() {
		String mePath = serversPath.concat("/").concat(serverData.getAddress());

		try {
			zkClient.createEphemeral(mePath, JSON.toJSONString(serverData).getBytes());
		} catch (ZkNoNodeException e) {
			zkClient.createPersistent(serversPath, true);
			registMe();
		}
	}

	private void updateConfig(ServerConfig serverConfig) {
		this.serverConfig = serverConfig;
	}

}
