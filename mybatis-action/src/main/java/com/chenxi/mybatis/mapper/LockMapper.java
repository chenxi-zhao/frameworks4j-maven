package com.chenxi.mybatis.mapper;

import com.chenxi.mybatis.beans.LockBean;
import org.apache.ibatis.annotations.Param;

/**
 * Created by chenxi on 2017/8/16.
 *
 * @author chenxi
 */
public interface LockMapper {
    /**
     * 添加锁
     *
     * @param lock
     * @return
     */
    public int saveLock(@Param("lock") LockBean lock);

    /**
     * 根据ID查询锁的资料
     *
     * @param id
     * @return
     */
    public LockBean findLockById(int id);

    /**
     * 根据ID查询锁与钥匙的资料
     * one2many
     *
     * @param id
     * @return
     */
    public LockBean findLockAndKeys(int id);
}
