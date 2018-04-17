package com.chenxi.elasticsearch.rest.query.enums;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/4/17
 */
public enum SortOrder {
    /**
     * Ascending order.
     */
    ASC {
        @Override
        public String toString() {
            return "asc";
        }
    },
    /**
     * Descending order.
     */
    DESC {
        @Override
        public String toString() {
            return "desc";
        }
    }
}
