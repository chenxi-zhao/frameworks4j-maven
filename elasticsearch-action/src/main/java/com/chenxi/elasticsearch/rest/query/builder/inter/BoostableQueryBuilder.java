package com.chenxi.elasticsearch.rest.query.builder.inter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/4/17
 */
public interface BoostableQueryBuilder<B extends BoostableQueryBuilder<B>> {

    /**
     * Sets the boost for this query.  Documents matching this query will (in addition to the normal
     * weightings) have their score multiplied by the boost provided.
     */
    B boost(float boost);

}
