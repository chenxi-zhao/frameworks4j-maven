package com.chenxi.elasticjob;

import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.lifecycle.api.JobOperateAPI;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.google.common.base.Optional;

/**
 * Created by zhaochx1 on 2017/1/19.
 *
 * @author zhaochx1
 */
public class JobOperates {
    private static ZookeeperConfiguration zkconfig;
    private static CoordinatorRegistryCenter registryCenter;
    private static boolean isInit = false;

    private JobOperateAPI jobOperateAPI = new JobAPIService().getJobOperatorAPI();

    public static void initZookeeperRegistryCenter() {
        if (!isInit) {
            zkconfig = new ZookeeperConfiguration(JobConstant.zkConnectURL, JobConstant.namespace);
            zkconfig.setDigest(JobConstant.digest);
            registryCenter = new ZookeeperRegistryCenter(zkconfig);
            registryCenter.init();
            isInit = true;
        }
    }

    public void scheduleJob(String jobName, String cron, Class JobClass) {
        initZookeeperRegistryCenter();
        LiteJobConfiguration liteJobConfiguration = JobConfigurationFactory.createSimpleJobConfiguration(jobName,
                JobClass, JobConstant.shardingTotalCount, cron, JobConstant.shadingParameters);
        JobScheduler jobScheduler = new JobScheduler(registryCenter, liteJobConfiguration);
        // 启动当前定时任务
        jobScheduler.init();
    }

    /**
     * 暂停定时任务
     *
     * @param jobName
     */
    public void pauseJob(String jobName) {
        for (String ipStr : JobConstant.serverIps) {
            jobOperateAPI.pause(Optional.fromNullable(jobName), Optional.fromNullable(ipStr));
        }
    }

    public void resumeJob(String jobName) {
        for (String ipStr : JobConstant.serverIps) {
            jobOperateAPI.resume(Optional.fromNullable(jobName), Optional.fromNullable(ipStr));
        }
    }

    public void removeJob(String jobName) {
        for (String ipStr : JobConstant.serverIps) {
            jobOperateAPI.remove(Optional.fromNullable(jobName), Optional.fromNullable(ipStr));
        }
    }

    public void shutdownJob(String jobName) {
        for (String ipStr : JobConstant.serverIps) {
            jobOperateAPI.shutdown(Optional.fromNullable(jobName), Optional.fromNullable(ipStr));
        }
    }
}
