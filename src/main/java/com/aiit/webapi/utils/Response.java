package com.aiit.webapi.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xingheng
 */
@Data
public class Response<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public Response(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 三种成功的多态
     * @param data
     * @param <E>
     * @return
     */
    public static <E> Response<E> success(E data) {
        return new Response<E>(200, "成功", data);
    }

    public static <E> Response<E> success(String message, E data) {
        return new Response<E>(200, message, data);
    }

    public static <E> Response<E> success() {
        return new Response<E>(200, "成功", null);
    }

    /**
     * 失败
     * @param <E>
     * @return
     */
    public static <E> Response<E> error(Integer code) {
        return new Response<E>(code, "失败", null);
    }
    public static <E> Response<E> error(Integer code, String msg) {
        return new Response<E>(code, msg, null);
    }
}
