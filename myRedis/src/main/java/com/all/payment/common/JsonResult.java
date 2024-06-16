package com.all.payment.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JsonResult<T> {

    private String code;
    private String msg;
    private T data;


    public static <T> JsonResult<T> success(String code, String msg) {
        return new JsonResult<T>(code, msg, null);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<T>("200", "success", data);
    }

    public static <T> JsonResult<T> success() {
        return new JsonResult<T>("200", null, null);
    }

    public static <T> JsonResult<T> fail(String code, String msg, T data) {
        return new JsonResult<T>(code, msg, data);
    }

    public static <T> JsonResult<T> fail(T data) {
        return new JsonResult<T>("500", "fail", data);
    }

    public static <T> JsonResult<T> fail(String msg, T data) {
        return new JsonResult<T>("500", msg, data);
    }
}
