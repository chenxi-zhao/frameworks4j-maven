package com.chenxi.mybatis.mapper;

import com.chenxi.mybatis.beans.UserBean;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by chenxi on 2017/8/16.
 *
 * @author chenxi
 */
public interface UserMapper {
    // 简单的增删改查可以使用注解
    // 注解+配置文件

    /**
     * 新增用戶
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Insert("insert into user value (null,user.userName,user.userAge,user.userAddress)")
    @Options(useGeneratedKeys = true, keyProperty = "user.id")
    public int insertUser(@Param("user") UserBean user) throws Exception;


    /**
     * 修改用戶
     *
     * @param user
     * @param id
     * @return
     * @throws Exception
     */
    @Update(" update user set userName=#{u.userName},userAge=#{u.userAge},userAddress=#{u.userAddress} where id=#{id}")
    public int updateUser(@Param("u") UserBean user, @Param("id") int id) throws Exception;

    /**
     * 刪除用戶
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Delete(" delete from user where id=#{id}  ")
    public int deleteUser(int id) throws Exception;


    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     * @throws Exception
     */

    @Select(" select * from user where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id", javaType = Integer.class),
            @Result(property = "userName", column = "userName", javaType = String.class),
            @Result(property = "userAge", column = "userAge", javaType = String.class),
            @Result(property = "userAddress", column = "userAddress", javaType = String.class)
    })
    public UserBean selectUserById(int id) throws Exception;


    /**
     * 查询所有的用户信息
     *
     * @return
     * @throws Exception
     */

    @Select(" select * from t_user")
    @ResultMap("userMap")
    public List<UserBean> selectAllUser() throws Exception;


    /**
     * 批量增加
     *
     * @param user
     * @return
     * @throws Exception
     */
    public int batchInsertUser(@Param("users") List<UserBean> user) throws Exception;

    /**
     * 批量删除
     *
     * @param list
     * @return
     * @throws Exception
     */
    public int batchDeleteUser(@Param("list") List<Integer> list) throws Exception;


    /**
     * 分页查询数据
     *
     * @param params
     * @return
     * @throws Exception
     */
    public List<UserBean> pagerUser(Map<String, Object> params) throws Exception;

    /**
     * 分页统计数据
     *
     * @param params
     * @return
     * @throws Exception
     */
    public int countUser(Map<String, Object> params) throws Exception;
}
