package cn.tuids.check.config;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

/**
 * @author tuids
 * @date 2024/1/21 2:10
 */
@Target({METHOD, FIELD, TYPE,PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
// 完成校验的类
@Constraint(validatedBy = {telMatchValidator.class})
public @interface TelMatch {

    // 校验错误时返回的消息
    String message() default "手机号不合法";

    //分组校验
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // 自定义属性
    boolean required() default true;

    String telFormat() default "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$";
}
