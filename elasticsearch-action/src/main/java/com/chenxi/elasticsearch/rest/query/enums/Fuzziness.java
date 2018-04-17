package com.chenxi.elasticsearch.rest.query.enums;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/4/17
 */
public enum Fuzziness {
    ZERO("0"){
        @Override
        public String toString() {
            return "0";
        }
    }, ONE("1"){
        @Override
        public String toString() {
            return "1";
        }
    }, TWO("2"){
        @Override
        public String toString() {
            return "2";
        }
    }, AUTO("AUTO"){
        @Override
        public String toString() {
            return "auto";
        }
    };

    private String value;

    Fuzziness(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
