package com.chenxi.springboot.service.impl;

import com.chenxi.springboot.dao.AccountXmlMapper;
import com.chenxi.springboot.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by chenxi on 2017/8/23.
 *
 * @author chenxi
 */
@Service
public class AccountMybatisXmlService {
    private AccountXmlMapper accountXmlMapper;

    @Autowired
    public void setAccountXmlMapper(AccountXmlMapper accountMapper) {
        this.accountXmlMapper = accountMapper;
    }

    public int add(String name, double money) {
        return accountXmlMapper.add(name, money);
    }

    public int update(String name, double money, int id) {
        return accountXmlMapper.update(name, money, id);
    }

    public int delete(int id) {
        return accountXmlMapper.delete(id);
    }

    public Account findAccount(int id) {
        return accountXmlMapper.findAccount(id);
    }

    public List<Account> findAccountList() {
        return accountXmlMapper.findAccountList();
    }

    /**
     * \@Transactional，声明事务，并设计一个转账方法，用户1减10块，用户2加10块。
     * <p>
     * 在用户1减10 ，之后，抛出异常，即用户2加10块钱不能执行，当加注解@Transactional之后，两个人的钱都没有增减。
     * <p>
     * 当不加@Transactional，用户1减了10，用户2没有增加，即没有操作用户2的数据。可见@Transactional注解开启了事务。
     *
     * @throws RuntimeException
     */
    @Transactional
    public void transfer() throws RuntimeException {
        accountXmlMapper.update("aaa", 90, 1);//用户1减10块 用户2加10块
        int i = 1 / 0;
        accountXmlMapper.update("bbb", 110, 2);
    }
}
