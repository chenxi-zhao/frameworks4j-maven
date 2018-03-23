package com.chenxi.hibernate.ManyToOne;

import javax.persistence.*;

/**
 * Created by chenxi on 2017/8/19.
 *
 * @author chenxi
 */

@Entity
@Table(name = "t_article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    //数据可能会非常长，映射为数据库支持的“大对象”
    private String content;

    /*
     * @ManyToOne 使用此标签建立多对一关联，此属性在“多”方使用注解在我们的“一”方属性上
     * @cascade 指定级联操作，以数组方式指定，如果只有一个，可以省略“{}”
     * @fetch 定义抓取策略
     * @optional 定义是否为必需属性，如果为必需（false），但在持久化时user=null,则会持久化失败
     * @targetEntity 目标关联对象，默认为被注解属性所在类
     */
    /*
     * CascadeType.MERGE	级联更新：若user属性修改了那么article对象保存/更新时同时修改user在数据库里的属性值
     * CascadeType.PERSIST	级联保存：对article对象保存时也对user里的对象也会保存。
     * CascadeType.REFRESH	级联刷新：获取article对象里也同时也重新获取最新的user时的对象。即会重新查询数据库里的最新数据
     * CascadeType.REMOVE	级联删除：对article对象删除也会使对应user对象删除
     * CascadeType.ALL	包含PERSIST, MERGE, REMOVE, REFRESH, DETACH等；
     *
     * 级联属性对于一方和多方的作用效果是不一样的。
     * 经测试发现，在多对一中，多方使用CascadeType.PERSIST无法级联保存对象，必须使用CascadeType.ALL。
     * 而级联删除既可使用CascadeType.REMOVE也可使用CascadeType.ALL
     */
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, optional = false, targetEntity = User.class)
    @JoinColumn(name = "user_id",referencedColumnName = "USERID")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
