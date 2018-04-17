package com.chenxi.elasticsearch.rest.query.builder;

import com.alibaba.fastjson.JSONObject;
import com.chenxi.elasticsearch.rest.query.builder.inter.BoostableQueryBuilder;
import com.chenxi.elasticsearch.rest.query.builder.inter.QueryBuilder;
import com.chenxi.elasticsearch.rest.query.enums.Fuzziness;
import com.chenxi.elasticsearch.rest.query.enums.MatchQueryOperator;
import com.chenxi.elasticsearch.rest.query.enums.MatchQueryType;
import com.chenxi.elasticsearch.rest.query.enums.ZeroTermsQuery;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/4/17
 */
public class MatchQueryBuilder extends QueryBuilder implements BoostableQueryBuilder<MatchQueryBuilder> {
    private transient final String name;

    private transient boolean isComplex;

    private final Object text;

    private MatchQueryType type;

    private MatchQueryOperator operator;

    private String analyzer;

    private Float boost;

    private Integer slop;

    private Fuzziness fuzziness;

    private Integer prefixLength;

    private Integer maxExpansions;

    private String minimumShouldMatch;

    private String fuzzyRewrite = null;

    private Boolean lenient;

    private Boolean fuzzyTranspositions = null;

    private ZeroTermsQuery zeroTermsQuery;

    private Float cutoff_Frequency = null;


    public MatchQueryBuilder(String name, Object text) {
        this.name = name;
        this.text = text;
    }

    public MatchQueryBuilder type(MatchQueryType type) {
        this.type = type;
        this.isComplex = true;
        return this;
    }

    public MatchQueryBuilder operator(MatchQueryOperator operator) {
        this.operator = operator;
        this.isComplex = true;
        return this;
    }

    public MatchQueryBuilder analyzer(String analyzer) {
        this.analyzer = analyzer;
        this.isComplex = true;
        return this;
    }

    @Override
    public MatchQueryBuilder boost(float boost) {
        this.boost = boost;
        this.isComplex = true;
        return this;
    }

    public MatchQueryBuilder slop(int slop) {
        this.slop = slop;
        this.isComplex = true;
        return this;
    }

    public MatchQueryBuilder fuzziness(Fuzziness fuzziness) {
        this.fuzziness = fuzziness;
        this.isComplex = true;
        return this;
    }

    public MatchQueryBuilder prefixLength(int prefixLength) {
        this.prefixLength = prefixLength;
        this.isComplex = true;
        return this;
    }

    public MatchQueryBuilder maxExpansions(int maxExpansions) {
        this.maxExpansions = maxExpansions;
        this.isComplex = true;
        return this;
    }

    public MatchQueryBuilder cutoffFrequency(float cutoff) {
        this.cutoff_Frequency = cutoff;
        this.isComplex = true;
        return this;
    }

    public MatchQueryBuilder minimumShouldMatch(String minimumShouldMatch) {
        this.minimumShouldMatch = minimumShouldMatch;
        this.isComplex = true;
        return this;
    }

    public MatchQueryBuilder fuzzyRewrite(String fuzzyRewrite) {
        this.fuzzyRewrite = fuzzyRewrite;
        this.isComplex = true;
        return this;
    }

    public MatchQueryBuilder fuzzyTranspositions(boolean fuzzyTranspositions) {
        this.fuzzyTranspositions = fuzzyTranspositions;
        this.isComplex = true;
        return this;
    }

    public MatchQueryBuilder setLenient(boolean lenient) {
        this.lenient = lenient;
        this.isComplex = true;
        return this;
    }

    public MatchQueryBuilder zeroTermsQuery(ZeroTermsQuery zeroTermsQuery) {
        this.zeroTermsQuery = zeroTermsQuery;
        this.isComplex = true;
        return this;
    }

    @Override
    public String getJSONContent() {
        if (!isComplex) {
            return "{" +
                    "\"match\":" + "{" +
                    JSONObject.toJSONString(this.name) + ":" + JSONObject.toJSONString(this.text) +
                    "}}";
        }
        return "{" +
                "\"match\":" + "{" +
                JSONObject.toJSONString(this.name) + ":" + getComplexContent() +
                "}}";
    }

    private String getComplexContent() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("query", this.text);
        jsonObject.put("type", this.type.toString());
        jsonObject.put("operator", this.operator.toString());
        jsonObject.put("analyzer", this.analyzer);
        jsonObject.put("boost", this.boost);
        jsonObject.put("slop", this.slop);
        jsonObject.put("fuzziness", this.fuzziness.toString());
        jsonObject.put("prefixLength", this.prefixLength);
        jsonObject.put("maxExpansions", this.maxExpansions);
        jsonObject.put("minimumShouldMatch", this.minimumShouldMatch);
        jsonObject.put("fuzzyRewrite", this.fuzzyRewrite);
        jsonObject.put("lenient", this.lenient);
        jsonObject.put("fuzzyTranspositions", this.fuzzyTranspositions);
        jsonObject.put("zeroTermsQuery", this.zeroTermsQuery.toString());
        jsonObject.put("cutoff_Frequency", this.cutoff_Frequency);

        return jsonObject.toJSONString();
    }
}
