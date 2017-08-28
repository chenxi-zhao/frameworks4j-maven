package com.chenxi.ssmd.exception;

/**
 * Created by chenxi on 2017/8/28.
 * <p>
 * 预约业务异常
 *
 * @author chenxi
 */
public class AppointException extends RuntimeException {

    public AppointException(String message) {
        super(message);
    }

    public AppointException(String message, Throwable cause) {
        super(message, cause);
    }

}
