package com.chenxi.mybatis.mapper;

import com.chenxi.mybatis.beans.KeyBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chenxi on 2017/8/16.
 *
 * @author chenxi
 */
public interface KeyMapper {
    /**
     * 批量添加钥匙
     *
     * @return 提倡 这样使用 @Param("keys")
     */
    public int batchSaveKeys(@Param("keys") List<KeyBean> keys);
}
