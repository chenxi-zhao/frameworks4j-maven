package com.chenxi.springboot.dao;

import com.chenxi.springboot.domain.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chenxi on 2017/8/23.
 *
 * @author chenxi
 */
public interface BankCardDao extends JpaRepository<BankCard, Integer> {
    // ![](http://static.tmaczhao.cn/images/cb2c829ff983a9941827435536d3443e.jpg)
    // http://blog.anxpp.com/usr/uploads/2016/05/1125701523.png
    // http://blog.csdn.net/anxpp/article/details/51415698

}
