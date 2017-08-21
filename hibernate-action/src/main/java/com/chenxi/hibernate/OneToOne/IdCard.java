package com.chenxi.hibernate.OneToOne;

import javax.persistence.*;

/**
 * Created by chenxi on 2017/8/20.
 *
 * @author chenxi
 */
@Entity
@Table(name = "t_idcard")
public class IdCard {
    private int id;
    private String cardNo;
    private Person person;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    //mappedBy：在指定当前对象在被Person对象的idCard做了映射了
    //此值：当前对象持有引用对象中引用当前对象的成员属性名称(getXXX后的名称)
    //因为Person对象的持有IdCard对象的方法是getIdCard()因为需要小写,所以为idCard
    @OneToOne(mappedBy = "idCard")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
