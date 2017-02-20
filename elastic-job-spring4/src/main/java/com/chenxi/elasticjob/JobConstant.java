package com.chenxi.elasticjob;

/**
 * Created by zhaochx1 on 2017/1/19.
 *
 * @author zhaochx1
 */
public class JobConstant {
    public static final String zkConnectURL = "192.168.208.128:2181";
    public static final String namespace = "elastic-job";
    public static final String digest = "admin:root";

    public static final int shardingTotalCount = 2;
    public static final String shadingParameters = "0=0,1=1";

    public static final String[] serverIps = {"192.168.208.1"};
}
