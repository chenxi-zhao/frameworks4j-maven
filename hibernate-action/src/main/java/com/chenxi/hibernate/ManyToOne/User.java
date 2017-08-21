package com.chenxi.hibernate.ManyToOne;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by chenxi on 2017/8/19.
 *
 * @author chenxi
 */
@Entity
@Table(name = "t_user")
public class User {
    //声明此列为主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")//进行注解为一对多的关系
//    @JoinColumn(name = "user_id")
    private Set<Article> articles;

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

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
