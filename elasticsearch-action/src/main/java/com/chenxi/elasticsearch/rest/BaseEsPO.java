package com.chenxi.elasticsearch.rest;

/**
 * 基础EsPO类
 *
 * @author chenxi.zhao
 */
public class BaseEsPO {
    private transient String esRouteId;

    /**
     * 更新版本次数，用作记录Es查询出的数据的更改次数
     */
    private transient Integer version;

    public String getEsRouteId() {
        return esRouteId;
    }

    public void setEsRouteId(String esRouteId) {
        this.esRouteId = esRouteId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
