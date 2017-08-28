package com.chenxi.ssmd.exception;

/**
 * Created by chenxi on 2017/8/28.
 * <p>
 * 库存不足异常
 *
 * @author chenxi
 */
public class NoNumberException extends RuntimeException {

    public NoNumberException(String message) {
        super(message);
    }

    public NoNumberException(String message, Throwable cause) {
        super(message, cause);
    }

}
