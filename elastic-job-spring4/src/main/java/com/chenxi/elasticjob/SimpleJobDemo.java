package com.chenxi.elasticjob;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.executor.handler.JobExceptionHandler;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhaochx1 on 2017/1/13.
 *
 * @author zhaochx1
 */
public class SimpleJobDemo implements SimpleJob,JobExceptionHandler {

    @Override
    public void execute(ShardingContext context) {
        int item = context.getShardingItem();
        String item_str = "";
        if (item == 0){
            item_str = "excute data by the sharding 0" + System.currentTimeMillis();
        }else if(item == 1){
            item_str = "excute data by the sharding 1" + System.currentTimeMillis();
        }
        System.out.println(context.getJobName() + "--" + item + ": " + item_str);
    }

    @Override
    public void handleException(String jobName, Throwable cause) {

    }
}
