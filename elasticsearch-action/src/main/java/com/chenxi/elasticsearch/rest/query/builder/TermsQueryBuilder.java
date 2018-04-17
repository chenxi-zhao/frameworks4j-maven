package com.chenxi.elasticsearch.rest.query.builder;

import com.alibaba.fastjson.JSONObject;
import com.chenxi.elasticsearch.rest.query.builder.inter.QueryBuilder;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/4/17
 */
public class TermsQueryBuilder extends QueryBuilder {
    public static final String NAME = "terms";

    private final String fieldName;
    private final List<?> values;

    public TermsQueryBuilder(String fieldName, List<?> values) {
        this.fieldName = fieldName;
        this.values = values;
    }


    @Override
    public String getJSONContent() {
        return "{" +
                "\"terms\":" + "{" +
                JSONObject.toJSONString(this.fieldName) + ":" + JSONObject.toJSONString(this.values) +
                "}}";
    }
}
