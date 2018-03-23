package com.chenxi.hibernate.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by chenxi on 2017/8/19.
 *
 * @author chenxi
 */
//声明当前类为hibernate映射到数据库中的实体类
//@Entity
//通过 @Table 为实体Bean指定对应数据库表，目录和schema的名字
//@UniqueConstraints 可以定义表的唯一约束。在title,和content加上唯一约束
//@Table(name = "t_user", catalog = "catolog", schema = "schema",
//        uniqueConstraints = {@UniqueConstraint(columnNames = {"title", "content"})})
public class User {

    //声明此列为主键
    @Id
    /*
     * @GeneratedValue注解来定义生成策略
     *  GenerationType.TABLES 当前主键的值单独保存到一个数据库的表中
     *  GenerationType.SEQUENCE  利用底层数据库提供的序列生成标识符
     *  GenerationType.IDENTITY 采取数据库的自增策略
     *  GenerationType.AUTO 根据不同数据库自动选择合适的id生成方案，这里使用mysql,为递增型
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 主键生成策略 http://blog.csdn.net/qwe6112071/article/details/51013437
    private Integer id;

    /*
     * unique 可选,是否在该列上设置唯一约束，默认为false
     * nullable	可选,是否设置该列的值可以为空，默认为	false
     * insertable 可选,该列是否作为生成的insert语句中的一个列	，默认为true
     * updatable 可选,该列是否作为生成的update语句中的一个列，默认true
     * length 可选,列长度，默认255
     * precision 可选,列十进制精度(decimal precision)，默认0
     * scale 可选,如果列十进制数值范围(decimal scale)可用,在此设置，默认0
     *
     * columnDefinition	可选: 为这个特定列覆盖SQL DDL片段 (这可能导致无法在不同数据库间移植)
     * 比如我们想把Integer readNum 设为默认0，可使用此属性： INT DEFAULT 0
     * table 可选,定义对应的表	默认为当前类对应表
     */
    @Column(insertable = true, length = 20, nullable = false, name = "user_name", unique = true, updatable = true)
    @Version //注解用于支持乐观锁版本控制。
    private String name;

    @Column(scale = 1, precision = 1)
    private Double salary;

    /*
     * @Basic 基本属性类型映射,注解于非Static 非transient的属性，
     * 这时候我们可以为其声明抓取策略等属性
     * fetch: 获取策略，当以session.get()方法获取数据库对象时：
     * fetchType.LAZY为懒加载，会在第一次使用该属性（如调用getAge()方法）时才获取。
     * FetchType.EAGER为即时加载。
     * optional:表示当前属性持久化时是否必选，默认为true，如果为false,则在持久化到数据库时，如果此属性为null，则会失败
     */
    @Basic(fetch = FetchType.EAGER, optional = true)
    private Integer age;

    //被标注此注解的属性不会被持久化到数据库
    @Transient
    private String temp;

    /*
     * @Lob 注解表示属性将被持久化为Blob或者Clob类型,
     * 具体取决于属性的类型, java.sql.Clob, Character[], char[] 和 java.lang.String这些类型的属性都被持久化为Clob类型,
     * 而java.sql.Blob, Byte[], byte[] 和 serializable类型则被持久化为Blob类型.
     */
    @Lob
    private String desc;

    /*
     * @Temporal 标注在日期等属性上，声明映射为数据库的特定诶其属性类型，
     * 默认为java.sql.Timestamp（TemporalType.TIMESTAMP）
     * 此外还有java.sql.date（TemporalType.DATE）、java.sql.Time（TemporalType.TIME）
     */
    @Temporal(TemporalType.TIME)
    private Date birthDate;

    /*
     * 如果某属性没有注解,该属性将遵守下面的规则:
     1. 如果属性为单一类型,则映射为@Basic
     2. 如果属性对应的类型实现了Serializable, 则属性被映射为@Basic并在一个列中保存该对象的serialized版本
     3. 如果该属性的类型为Java.sql.Clob 或 java.sql.Blob,则作为@Lob并映射到适当的LobType。
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
