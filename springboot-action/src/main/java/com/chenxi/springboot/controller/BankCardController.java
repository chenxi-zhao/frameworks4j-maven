package com.chenxi.springboot.controller;

import com.chenxi.springboot.dao.BankCardDao;
import com.chenxi.springboot.domain.BankCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenxi on 2017/8/23.
 *
 * 整合 jpa
 *
 * @author chenxi
 */
@RestController
@RequestMapping("/bankcard")
public class BankCardController {
    private BankCardDao bankCardDao;

    @Autowired
    public void setBankCardDao(BankCardDao bankCardDao) {
        this.bankCardDao = bankCardDao;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<BankCard> getAccounts() {
        return bankCardDao.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BankCard getAccountById(@PathVariable("id") int id) {
        return bankCardDao.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {
        BankCard account = new BankCard();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        BankCard account1 = bankCardDao.saveAndFlush(account);

        return account1.toString();

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money) {
        BankCard account = new BankCard();
        account.setMoney(money);
        account.setName(name);
        BankCard account1 = bankCardDao.save(account);
        return account1.toString();

    }
}
