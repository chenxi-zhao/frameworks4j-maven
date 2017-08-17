package com.chenxi.mybatis.service;

import com.chenxi.mybatis.beans.HusbandBean;
import com.chenxi.mybatis.mapper.HusbandMapper;
import com.chenxi.mybatis.tools.DBTools;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by chenxi on 2017/8/16.
 *
 * @author chenxi
 */
public class OneToOneService {
    public static void main(String[] args) {
        selectHusbandAndWife();
    }

    public static void selectHusbandAndWife() {
        SqlSession session = DBTools.getSession();
        HusbandMapper husbandMapper = session.getMapper(HusbandMapper.class);
        try {
            HusbandBean husbandBean = husbandMapper.selectHusbandAndWife(1);
            System.out.println(husbandBean);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
