package com.chenxi.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by chenxi on 2017/8/22.
 *
 * @author chenxi
 */
@Component
@ConfigurationProperties(prefix = "my")
@PropertySource("classpath:my.properties")
public class RandomValues {
    private String secret;
    private String number;
    private String bigNumber;
    private String numberLessThanTen;
    private String numberInRange;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBigNumber() {
        return bigNumber;
    }

    public void setBigNumber(String bigNumber) {
        this.bigNumber = bigNumber;
    }

    public String getNumberLessThanTen() {
        return numberLessThanTen;
    }

    public void setNumberLessThanTen(String numberLessThanTen) {
        this.numberLessThanTen = numberLessThanTen;
    }

    public String getNumberInRange() {
        return numberInRange;
    }

    public void setNumberInRange(String numberInRange) {
        this.numberInRange = numberInRange;
    }
}
