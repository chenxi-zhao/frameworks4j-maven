package com.chenxi.elasticjob;

import com.dangdang.ddframe.job.lite.lifecycle.api.*;
import com.google.common.base.Optional;

/**
 * Created by zhaochx1 on 2017/1/19.
 *
 * @author zhaochx1
 */
public class JobAPIService {
    /**
     * 创建作业配置API对象.
     */
    public JobSettingsAPI getJobSettingsAPI() {
        return JobAPIFactory.createJobSettingsAPI(JobConstant.zkConnectURL, JobConstant.namespace,
                Optional.fromNullable(JobConstant.digest));
    }

    /**
     * 创建操作作业API对象.
     */
    public JobStatisticsAPI getJobStatisticsAPI() {
        return JobAPIFactory.createJobStatisticsAPI(JobConstant.zkConnectURL, JobConstant.namespace,
                Optional.fromNullable(JobConstant.digest));
    }

    /**
     * 创建作业状态展示API对象.
     */
    public ServerStatisticsAPI getServerStatisticsAPI() {
        return JobAPIFactory.createServerStatisticsAPI(JobConstant.zkConnectURL, JobConstant.namespace,
                Optional.fromNullable(JobConstant.digest));
    }

    /**
     * 创建作业服务器状态展示API对象.
     */
    public JobOperateAPI getJobOperatorAPI() {
        return JobAPIFactory.createJobOperateAPI(JobConstant.zkConnectURL, JobConstant.namespace,
                Optional.fromNullable(JobConstant.digest));
    }
}
