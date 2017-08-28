package com.chenxi.zookeeper.balancing.client;

public interface Client {

	public void connect() throws Exception;

	public void disConnect() throws Exception;

}
