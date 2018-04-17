package com.chenxi.elasticsearch.rest.query.builder;

import com.alibaba.fastjson.JSONObject;
import com.chenxi.elasticsearch.rest.query.builder.inter.QueryBuilder;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/4/17
 */
public class TermQueryBuilder extends QueryBuilder {
    private final String fieldName;
    private final Object value;

    /**
     * Constructs a new term query.
     *
     * @param fieldName The name of the field
     * @param value     The value of the term
     */
    public TermQueryBuilder(String fieldName, Object value) {
        this.fieldName = fieldName;
        this.value = value;
    }


    @Override
    public String getJSONContent() {
        return "{" +
                "\"term\":" + "{" +
                JSONObject.toJSONString(this.fieldName) + ":" + JSONObject.toJSONString(this.value) +
                "}}";
    }
}
