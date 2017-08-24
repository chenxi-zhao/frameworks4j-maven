package com.chenxi.springboot.controller;

import com.chenxi.springboot.domain.Account;
import com.chenxi.springboot.service.impl.AccountMybatisXmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenxi on 2017/8/23.
 *
 * @author chenxi
 */
@RestController
@RequestMapping("/mybatisxml/account")
public class AccountMyBatisXmlController {
    private AccountMybatisXmlService accountMybatisXmlService;

    @Autowired
    public void setAccountMybatisXmlService(AccountMybatisXmlService accountMybatisXmlService) {
        this.accountMybatisXmlService = accountMybatisXmlService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountMybatisXmlService.findAccountList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id) {
        return accountMybatisXmlService.findAccount(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {
        int t = accountMybatisXmlService.update(name, money, id);
        if (t == 1) {
            return "success";
        } else {
            return "fail";
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") int id) {
        int t = accountMybatisXmlService.delete(id);
        if (t == 1) {
            return "success";
        } else {
            return "fail";
        }

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money) {

        int t = accountMybatisXmlService.add(name, money);
        if (t == 1) {
            return "success";
        } else {
            return "fail";
        }

    }
}
