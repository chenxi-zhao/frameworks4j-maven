package com.chenxi.elasticsearch.rest;

import com.chenxi.elasticsearch.rest.query.QueryBuilders;
import com.chenxi.elasticsearch.rest.query.SearchSourceBuilder;
import com.chenxi.elasticsearch.rest.query.builder.BoolQueryBuilder;
import com.chenxi.elasticsearch.rest.query.enums.SortOrder;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/4/17
 */
public class QueryTest {
    public static void main(String[] args) {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(30);

        searchSourceBuilder.version(true);
        searchSourceBuilder.explain(false);

        searchSourceBuilder.sort("rel_submit_date", SortOrder.DESC);
        searchSourceBuilder.sort("video_id", SortOrder.DESC);


        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();

        boolQueryBuilder.filter(QueryBuilders.termQuery("video_type", 2));

        BoolQueryBuilder tempBoolQueryBuilder = new BoolQueryBuilder();
        tempBoolQueryBuilder.should(QueryBuilders.termQuery("status", 3));

        BoolQueryBuilder tempBoolQueryBuilder2 = new BoolQueryBuilder();
        tempBoolQueryBuilder2.filter(QueryBuilders.termsQuery("status", Arrays.asList(4, 8)));
        tempBoolQueryBuilder2.filter(QueryBuilders.rangeQuery("rel_apply_count").gt(0));

        tempBoolQueryBuilder.should(tempBoolQueryBuilder2);

        boolQueryBuilder.filter(tempBoolQueryBuilder);


        searchSourceBuilder.query(boolQueryBuilder);

        System.out.println(searchSourceBuilder.getSearchContent());
    }
}
