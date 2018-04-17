package com.chenxi.elasticsearch.rest.query;


import com.chenxi.elasticsearch.rest.query.builder.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/4/17
 */
public abstract class QueryBuilders {
    public static BoolQueryBuilder boolQuery() {
        return new BoolQueryBuilder();
    }

    public static MatchAllQueryBuilder matchAllQuery() {
        return new MatchAllQueryBuilder();
    }

    public static MatchQueryBuilder matchQuery(String name, Object text) {
        return new MatchQueryBuilder(name, text);
    }

    public static TermQueryBuilder termQuery(String name, Object value) {
        return new TermQueryBuilder(name, value);
    }

    public static TermsQueryBuilder termsQuery(String name, List<Object> value) {
        return new TermsQueryBuilder(name, value);
    }

    public static PrefixQueryBuilder prefixQuery(String name, String prefix) {
        return new PrefixQueryBuilder(name, prefix);
    }

    public static RangeQueryBuilder rangeQuery(String name) {
        return new RangeQueryBuilder(name);
    }

    private QueryBuilders() {
    }
}