package com.chenxi.elasticsearch.rest.query.enums;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/4/17
 */
public enum MatchQueryType {
    /**
     * The query is analyzed and terms are added to a boolean query.
     */
    BOOLEAN {
        @Override
        public String toString() {
            return "boolean";
        }
    },
    /**
     * The query is analyzed and used as a phrase query.
     */
    PHRASE {
        @Override
        public String toString() {
            return "phrase";
        }
    },
    /**
     * The query is analyzed and used in a phrase query, with the last term acting as a prefix.
     */
    PHRASE_PREFIX {
        @Override
        public String toString() {
            return "phrase_prefix";
        }
    }
}
