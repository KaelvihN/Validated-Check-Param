package cn.tuids.check.config;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.method.ParameterValidationResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author tuids
 * @date 2024/1/18 23:53
 */

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理@RequestBody参数校验报错
     * 和
     * 处理json请求体调用接口校验失败抛出的异常
     * <p>
     * (支持 @Valid 和 @Validator)
     */
    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    public Result bindExceptionHandle(BindException e) {
        // 获取校验异常的字段的信息
        List<FieldError> errorFields = e.getBindingResult().getFieldErrors();
        // 获取具体的message
        List<String> errorMsgs = errorFields.stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
        return Result.fail(StatusCodeEnum.PARAMETER_ERROR, errorMsgs);
    }

    /**
     * 处理单个参数校验失败抛出的异常
     * <p>
     * (支持@Validator)
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result constraintViolationExceptionHandler(ConstraintViolationException e) {
        // 获取校验异常的字段的信息
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        // 获取具体的message
        List<String> errorMsgs = constraintViolations.stream()
                .map(error -> error.getMessage())
                .collect(Collectors.toList());
        return Result.fail(StatusCodeEnum.PARAMETER_ERROR, errorMsgs);
    }


    @ExceptionHandler(HandlerMethodValidationException.class)
    public Result exceptionHandle(HandlerMethodValidationException e) {
        List<String> errorMsgs = new ArrayList<>();
        List<ParameterValidationResult> valueResults = e.getValueResults();
        for (ParameterValidationResult valueResult : valueResults) {
            List<MessageSourceResolvable> resolvableErrors = valueResult.getResolvableErrors();
            for (MessageSourceResolvable resolvableError : resolvableErrors) {
                String errorMsg = resolvableError.getDefaultMessage();
                errorMsgs.add(errorMsg);
            }
        }
        return Result.fail(StatusCodeEnum.PARAMETER_ERROR, errorMsgs);
    }

}




