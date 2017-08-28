package com.chenxi.ssmd.exception;

/**
 * Created by chenxi on 2017/8/28.
 * <p>
 * 重复预约异常
 *
 * @author chenxi
 */
public class RepeatAppointException extends RuntimeException {

    public RepeatAppointException(String message) {
        super(message);
    }

    public RepeatAppointException(String message, Throwable cause) {
        super(message, cause);
    }

}
