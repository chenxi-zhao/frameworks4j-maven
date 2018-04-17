package com.chenxi.elasticsearch.rest.query;

import com.chenxi.elasticsearch.rest.query.builder.FieldSortBuilder;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/4/17
 */
public class SortBuilders {
    public static FieldSortBuilder fieldSort(String field) {
        return new FieldSortBuilder(field);
    }
}
