package com.chenxi.elasticsearch.rest.query.enums;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/4/17
 */
public enum ZeroTermsQuery {
    NONE {
        @Override
        public String toString() {
            return "none";
        }
    },
    ALL {
        @Override
        public String toString() {
            return "all";
        }
    }
}
