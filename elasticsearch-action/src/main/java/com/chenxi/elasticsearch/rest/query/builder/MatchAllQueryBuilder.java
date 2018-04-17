package com.chenxi.elasticsearch.rest.query.builder;


import com.chenxi.elasticsearch.rest.query.builder.inter.BoostableQueryBuilder;
import com.chenxi.elasticsearch.rest.query.builder.inter.QueryBuilder;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/4/17
 */
public class MatchAllQueryBuilder extends QueryBuilder implements BoostableQueryBuilder<MatchAllQueryBuilder> {
    private float boost = -1;

    @Override
    public MatchAllQueryBuilder boost(float boost) {
        this.boost = boost;
        return this;
    }

    @Override
    public String getJSONContent() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("\"match_all\":{");

        if(boost != -1){
            builder.append("\"boost\":").append(boost);
        }

        builder.append("}}");
        return builder.toString();
    }
}
