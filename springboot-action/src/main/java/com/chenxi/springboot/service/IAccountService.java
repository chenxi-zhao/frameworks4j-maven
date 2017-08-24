package com.chenxi.springboot.service;

import com.chenxi.springboot.domain.Account;

import java.util.List;

/**
 * Created by chenxi on 2017/8/23.
 *
 * @author chenxi
 */
public interface IAccountService {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
