package com.chenxi.elasticsearch.rest.query.builder;

import com.alibaba.fastjson.JSONObject;
import com.chenxi.elasticsearch.rest.query.builder.inter.SortBuilder;
import com.chenxi.elasticsearch.rest.query.enums.SortOrder;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/4/17
 */
public class FieldSortBuilder extends SortBuilder {
    private final String fieldName;

    private SortOrder order;

    /**
     * Constructs a new sort based on a document field.
     *
     * @param fieldName The field name.
     */
    public FieldSortBuilder(String fieldName) {
        if (fieldName == null) {
            throw new IllegalArgumentException("fieldName must not be null");
        }
        this.fieldName = fieldName;
    }

    /**
     * The order of sorting. Defaults to {@link SortOrder#ASC}.
     */
    @Override
    public FieldSortBuilder order(SortOrder order) {
        this.order = order;
        return this;
    }

    @Override
    public String getJSONContent() {
        return "{" +
                JSONObject.toJSONString(this.fieldName) + ":{" +
                "\"order\":" + JSONObject.toJSONString(this.order) + "}" +
                "}";
    }
}
