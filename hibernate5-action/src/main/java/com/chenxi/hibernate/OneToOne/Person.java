package com.chenxi.hibernate.OneToOne;

import javax.persistence.*;

/**
 * Created by chenxi on 2017/8/20.
 *
 * @author chenxi
 */
@Entity
@Table(name = "t_person")
public class Person {
    private int id;
    private IdCard idCard;//引用IdCard对象
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    @OneToOne//表示一对一的关系
    @JoinColumn(name = "idCard", unique = true)//为数据中的外键指定个名称
    public IdCard getIdCard() {
        return idCard;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }

    public void setName(String name) {
        this.name = name;
    }
}
