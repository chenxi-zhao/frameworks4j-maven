package com.chenxi.springboot.dao;

import com.chenxi.springboot.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chenxi on 2017/8/23.
 *
 * @author chenxi
 */
@Mapper
public interface AccountXmlMapper {
    int add(@Param("name") String name, @Param("money") double money);

    int update(@Param("name") String name, @Param("money") double money, @Param("id") int id);

    int delete(int id);

    Account findAccount(@Param("id") int id);

    List<Account> findAccountList();
}
