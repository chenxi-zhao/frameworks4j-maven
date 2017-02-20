package com.chenxi.elasticjob;

import com.dangdang.ddframe.job.executor.handler.ExecutorServiceHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhaochx1 on 2017/1/18.
 *
 * @author zhaochx1
 */
public class JobThreadPool implements ExecutorServiceHandler {
    private static ExecutorService executorService;

    @Override
    public ExecutorService createExecutorService(String jobName) {
        if(executorService == null){
            executorService = Executors.newFixedThreadPool(5);
        }
        return executorService;
    }
}
