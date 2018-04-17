package com.chenxi.elasticsearch.rest.query.builder;

import com.chenxi.elasticsearch.rest.query.builder.inter.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/4/17
 */
public class BoolQueryBuilder extends QueryBuilder {
    private final List<QueryBuilder> mustClauses = new ArrayList<>();
    private final List<QueryBuilder> mustNotClauses = new ArrayList<>();
    private final List<QueryBuilder> filterClauses = new ArrayList<>();
    private final List<QueryBuilder> shouldClauses = new ArrayList<>();

    public BoolQueryBuilder() {
    }

    public BoolQueryBuilder must(QueryBuilder queryBuilder) {
        if (queryBuilder == null) {
            throw new IllegalArgumentException("inner bool query clause cannot be null");
        }
        mustClauses.add(queryBuilder);
        return this;
    }

    public List<QueryBuilder> must() {
        return this.mustClauses;
    }


    public BoolQueryBuilder filter(QueryBuilder queryBuilder) {
        if (queryBuilder == null) {
            throw new IllegalArgumentException("inner bool query clause cannot be null");
        }
        filterClauses.add(queryBuilder);
        return this;
    }

    public List<QueryBuilder> filter() {
        return this.filterClauses;
    }


    public BoolQueryBuilder mustNot(QueryBuilder queryBuilder) {
        if (queryBuilder == null) {
            throw new IllegalArgumentException("inner bool query clause cannot be null");
        }
        mustNotClauses.add(queryBuilder);
        return this;
    }

    public List<QueryBuilder> mustNot() {
        return this.mustNotClauses;
    }


    public BoolQueryBuilder should(QueryBuilder queryBuilder) {
        if (queryBuilder == null) {
            throw new IllegalArgumentException("inner bool query clause cannot be null");
        }
        shouldClauses.add(queryBuilder);
        return this;
    }

    public List<QueryBuilder> should() {
        return this.shouldClauses;
    }


    @Override
    public String getJSONContent() {
        boolean havaClauses = false;
        StringBuilder builder = new StringBuilder();
        builder.append("{");

        builder.append("\"bool\":").append("{");

        if (this.filterClauses.size() > 0) {
            havaClauses = true;
            builder.append("\"filter\":").append(getListBuilderContent(this.filterClauses)).append(",");
        }

        if (this.mustClauses.size() > 0) {
            havaClauses = true;
            builder.append("\"must\":").append(getListBuilderContent(this.mustClauses)).append(",");
        }

        if (this.mustNotClauses.size() > 0) {
            havaClauses = true;
            builder.append("\"must_not\":").append(getListBuilderContent(this.mustNotClauses)).append(",");
        }

        if (this.shouldClauses.size() > 0) {
            havaClauses = true;
            builder.append("\"should\":").append(getListBuilderContent(this.shouldClauses)).append(",");
        }

        if (havaClauses) {
            builder.deleteCharAt(builder.length() - 1);
        }

        builder.append("}}");
        return builder.toString();
    }


    private String getListBuilderContent(List<QueryBuilder> queryBuilders) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (QueryBuilder queryBuilder : queryBuilders) {
            builder.append(queryBuilder.getJSONContent()).append(",");
        }

        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}
