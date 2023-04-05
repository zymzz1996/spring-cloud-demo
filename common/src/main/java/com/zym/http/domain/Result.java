package com.zym.http.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@NoArgsConstructor
@Data
@ToString
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String msg;

    private T data;

    public Result(String msg) {
        this.msg = msg;
    }

    public Result(Integer code, String msg) {
        this.msg = msg;
        this.code = String.valueOf(code);
    }

    public Result(int code, String msg, T data) {
        this(code, msg);
        this.data = data;
    }

    public static <T> Result<T> success() {
        return new Result<>(HttpStatus.OK.value(), "success");
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(HttpStatus.OK.value(), "success", data);
    }

    public static <T> Result<T> fail() {
        return new Result<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),"fail");
    }

}
