package com.chenxi.elasticsearch.rest.query.builder;

import com.alibaba.fastjson.JSONObject;
import com.chenxi.elasticsearch.rest.query.builder.inter.QueryBuilder;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/4/17
 */
public class PrefixQueryBuilder extends QueryBuilder {
    public static final String NAME = "prefix";

    private final String fieldName;

    private final String value;

    public PrefixQueryBuilder(String fieldName, String value) {
        if (fieldName == null || "".equals(fieldName)) {
            throw new IllegalArgumentException("field name is null or empty");
        }
        if (value == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
        this.fieldName = fieldName;
        this.value = value;
    }

    @Override
    public String getJSONContent() {
        return "{" +
                "\"prefix\":" + "{" +
                JSONObject.toJSONString(this.fieldName) + ":" + JSONObject.toJSONString(this.value) +
                "}}";
    }
}
