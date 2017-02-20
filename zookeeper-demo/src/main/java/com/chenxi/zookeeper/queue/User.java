package com.chenxi.zookeeper.queue;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	String name;
	String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
