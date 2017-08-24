package com.chenxi.springboot.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by chenxi on 2017/8/22.
 *
 * @author chenxi
 */
@XmlRootElement
public class XmlThing {
    private Date when;
    private String thingTodo;

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public String getThingTodo() {
        return thingTodo;
    }

    public void setThingTodo(String thingTodo) {
        this.thingTodo = thingTodo;
    }
}
