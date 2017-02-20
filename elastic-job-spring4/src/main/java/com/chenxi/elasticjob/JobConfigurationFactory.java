package com.chenxi.elasticjob;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.dataflow.DataflowJobConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;

/**
 * Created by zhaochx1 on 2017/1/13.
 *
 * @author zhaochx1
 */
public class JobConfigurationFactory {
    public static LiteJobConfiguration createDataFlowJobConfiguration(String jobName, Class jobClass, int shardingTotalCount,
                                                                      String cron, String shardingParameters) {
        // 创建作业配置
        JobCoreConfiguration coreConfig = JobCoreConfiguration.newBuilder(jobName, cron, shardingTotalCount).jobProperties
                ("executor_service_handler", JobThreadPool.class.getCanonicalName()).build();
        DataflowJobConfiguration dataflowJobConfig = new DataflowJobConfiguration(coreConfig, jobClass.getCanonicalName(), true);
        LiteJobConfiguration result = LiteJobConfiguration.newBuilder(dataflowJobConfig).overwrite(true).build();
        return result;
    }

    public static LiteJobConfiguration createSimpleJobConfiguration(String jobName, Class jobClass, int shardingTotalCount,
                                                                    String cron, String shardingParameters) {
        // 定义作业核心配置
        JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration.newBuilder(jobName, cron, shardingTotalCount)
                .shardingItemParameters(shardingParameters).jobProperties("executor_service_handler", JobThreadPool.class
                        .getCanonicalName()).build();
        // 定义SIMPLE类型配置
        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig, jobClass.getCanonicalName());
        // 定义Lite作业根配置
        LiteJobConfiguration simpleJobRootConfig = LiteJobConfiguration.newBuilder(simpleJobConfig).overwrite(true).build();
        return simpleJobRootConfig;
    }

}
