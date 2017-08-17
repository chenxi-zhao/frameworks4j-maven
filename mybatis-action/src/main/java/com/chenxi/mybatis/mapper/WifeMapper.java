package com.chenxi.mybatis.mapper;

import com.chenxi.mybatis.beans.WifeBean;

/**
 * Created by chenxi on 2017/8/16.
 *
 * @author chenxi
 */
public interface WifeMapper {
    /**
     * 根据丈夫id查询妻子信息
     * @param id
     * @return
     * @throws Exception
     */
    public WifeBean selectWifeByHusbandId(int id) throws Exception;

}
