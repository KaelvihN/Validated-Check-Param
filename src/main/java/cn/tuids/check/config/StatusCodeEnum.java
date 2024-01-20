package cn.tuids.check.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tuids
 * @date 2024/1/19 21:36
 */
@Getter
@AllArgsConstructor
public enum StatusCodeEnum {

    SUCCESS(200, "操作成功"),
    FAIL(500, "未知异常"),
    PARAMETER_ERROR(400, "参数校验异常");


    private final Integer code;

    private final String desc;

}
