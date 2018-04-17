package com.chenxi.elasticsearch.rest.query.builder;

import com.alibaba.fastjson.JSONObject;
import com.chenxi.elasticsearch.rest.query.builder.inter.QueryBuilder;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/4/17
 */
public class RangeQueryBuilder extends QueryBuilder {
    public static final String NAME = "range";

    public static final boolean DEFAULT_INCLUDE_UPPER = true;
    public static final boolean DEFAULT_INCLUDE_LOWER = true;

    private final String fieldName;

    private Object from;

    private Object to;

    private boolean includeLower = DEFAULT_INCLUDE_LOWER;

    private boolean includeUpper = DEFAULT_INCLUDE_UPPER;


    /**
     * A Query that matches documents within an range of terms.
     *
     * @param fieldName The field name
     */
    public RangeQueryBuilder(String fieldName) {
        if (fieldName == null || "".equals(fieldName.trim())) {
            throw new IllegalArgumentException("field name is null or empty");
        }
        this.fieldName = fieldName;
    }

    public RangeQueryBuilder from(Object from, boolean includeLower) {
        this.from = from;
        this.includeLower = includeLower;
        return this;
    }

    public RangeQueryBuilder from(Object from) {
        return from(from, this.includeLower);
    }

    public RangeQueryBuilder gt(Object from) {
        return from(from, false);
    }

    public RangeQueryBuilder gte(Object from) {
        return from(from, true);
    }


    public RangeQueryBuilder to(Object to, boolean includeUpper) {
        this.to = to;
        this.includeUpper = includeUpper;
        return this;
    }

    public RangeQueryBuilder to(Object to) {
        return to(to, this.includeUpper);
    }

    public RangeQueryBuilder lt(Object to) {
        return to(to, false);
    }

    public RangeQueryBuilder lte(Object to) {
        return to(to, true);
    }


    /**
     * Should the lower bound be included or not. Defaults to <tt>true</tt>.
     */
    public RangeQueryBuilder includeLower(boolean includeLower) {
        this.includeLower = includeLower;
        return this;
    }

    /**
     * Gets the includeLower flag for this query.
     */
    public boolean includeLower() {
        return this.includeLower;
    }

    /**
     * Should the upper bound be included or not. Defaults to <tt>true</tt>.
     */
    public RangeQueryBuilder includeUpper(boolean includeUpper) {
        this.includeUpper = includeUpper;
        return this;
    }

    /**
     * Gets the includeUpper flag for this query.
     */
    public boolean includeUpper() {
        return this.includeUpper;
    }

    @Override
    public String getJSONContent() {
        return "{" +
                "\"range\":" + "{" +
                JSONObject.toJSONString(this.fieldName) + ":" + getObjString() +
                "}}";
    }


    private String getObjString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("from", from);
        jsonObject.put("to", to);
        jsonObject.put("include_lower", includeLower);
        jsonObject.put("include_upper", includeUpper);

        return jsonObject.toJSONString();
    }
}
