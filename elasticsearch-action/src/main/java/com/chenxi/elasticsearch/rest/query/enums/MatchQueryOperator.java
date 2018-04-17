package com.chenxi.elasticsearch.rest.query.enums;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/4/17
 */
public enum MatchQueryOperator {
    OR {
        @Override
        public String toString() {
            return "or";
        }
    }, AND {
        @Override
        public String toString() {
            return "and";
        }
    }
}
