package cn.tuids.check.config;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tuids
 * @date 2024/1/18 23:56
 */

@Setter
@Getter
public class Result<T> {

    private Boolean flag;

    private Integer code;

    private String message;

    private T data;

    private Result(Boolean flag, Integer code, String message, T data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success() {
        return new Result<T>(true, StatusCodeEnum.SUCCESS.getCode(), StatusCodeEnum.SUCCESS.getDesc(), null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(true, StatusCodeEnum.SUCCESS.getCode(), StatusCodeEnum.SUCCESS.getDesc(), data);
    }

    public static <T> Result<T> success(T data, String message) {
        return new Result<T>(true, StatusCodeEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> Result<T> fail() {
        return new Result<T>(false, StatusCodeEnum.FAIL.getCode(), StatusCodeEnum.FAIL.getDesc(), null);
    }

    public static <T> Result<T> fail(StatusCodeEnum codeEnum) {
        return new Result<T>(false, codeEnum.getCode(), codeEnum.getDesc(), null);
    }


    public static <T> Result<T> fail(StatusCodeEnum codeEnum, T data) {
        return new Result<T>(false, codeEnum.getCode(), codeEnum.getDesc(), data);
    }

}
