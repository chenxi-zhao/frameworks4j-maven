package com.chenxi.elasticjob;

/**
 * Hello world!
 */
public class TestElasticJobs {

    public static void main(String[] args) throws InterruptedException {
        int size = 50;
        String jobNamePrefix = "TestJob_";
        String cron = "0/2 * * * * ?";
        JobOperates jobOperate = new JobOperates();

        Thread.sleep(20000);
        for (int i = 0; i < size; i++) {
            jobOperate.removeJob(jobNamePrefix + i);
        }

        for (int i = 0; i < size; i++) {
            jobOperate.scheduleJob(jobNamePrefix + i, cron, SimpleJobDemo.class);
        }

        Thread.sleep(10000);
        for (int i = 0; i < size; i++) {
            jobOperate.pauseJob(jobNamePrefix + i);
        }
    }
}
