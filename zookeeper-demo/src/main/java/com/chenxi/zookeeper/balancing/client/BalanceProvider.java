package com.chenxi.zookeeper.balancing.client;

public interface BalanceProvider<T> {

	public T getBalanceItem();

}
