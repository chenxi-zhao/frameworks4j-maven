package com.chenxi.elasticsearch.rest.query.builder.inter;

import com.chenxi.elasticsearch.rest.query.enums.SortOrder;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/4/17
 */
public abstract class SortBuilder{
    /**
     * The order of sorting. Defaults to {@link SortOrder#ASC}.
     */
    public abstract SortBuilder order(SortOrder order);

    public abstract String getJSONContent();
}
