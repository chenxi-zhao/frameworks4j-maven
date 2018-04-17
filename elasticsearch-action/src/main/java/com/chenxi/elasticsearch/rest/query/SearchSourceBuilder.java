package com.chenxi.elasticsearch.rest.query;

import com.chenxi.elasticsearch.rest.query.builder.inter.QueryBuilder;
import com.chenxi.elasticsearch.rest.query.builder.inter.SortBuilder;
import com.chenxi.elasticsearch.rest.query.enums.SortOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/4/17
 */
public class SearchSourceBuilder {
    private Integer from = 0;

    private Integer size = 100;

    private QueryBuilder queryBuilder;

    private Boolean version;

    private Boolean explain;

    private List<SortBuilder> sorts;

    public SearchSourceBuilder query(QueryBuilder query) {
        this.queryBuilder = query;
        return this;
    }

    public SearchSourceBuilder from(int from) {
        if (from < 0) {
            throw new IllegalArgumentException("[from] parameter cannot be negative");
        }
        this.from = from;
        return this;
    }

    public SearchSourceBuilder size(int size) {
        this.size = size;
        return this;
    }

    public SearchSourceBuilder version(Boolean version) {
        this.version = version;
        return this;
    }

    public SearchSourceBuilder explain(Boolean explain) {
        this.explain = explain;
        return this;
    }

    public SearchSourceBuilder sort(String name, SortOrder order) {
        return sort(SortBuilders.fieldSort(name).order(order));
    }
    public SearchSourceBuilder sort(SortBuilder sort) {
        if (sorts == null) {
            sorts = new ArrayList<>();
        }
        sorts.add(sort);
        return this;
    }

    public String getSearchContent() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");

        builder.append("\"from\":").append(from).append(",").append("\"size\":").append(size);

        if(this.queryBuilder != null){
            builder.append(",\"query\":").append(this.queryBuilder.getJSONContent());
        }
        if(this.version != null){
            builder.append(",\"version\":").append(version);
        }

        if(this.explain != null ){
            builder.append(",\"explain\":").append(explain);
        }

        if(sorts != null){
            builder.append(",\"sort\":").append("[");
            for(SortBuilder sortBuilder: sorts){
                builder.append(sortBuilder.getJSONContent()).append(",");
            }
            builder.deleteCharAt(builder.length() - 1);

            builder.append("]");
        }

        builder.append("}");
        return builder.toString();
    }
}
