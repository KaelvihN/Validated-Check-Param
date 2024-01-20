package cn.tuids.check.config;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

/**
 * @author tuids
 * @date 2024/1/21 2:12
 */
public class telMatchValidator implements ConstraintValidator<TelMatch, String> {
    private boolean required;
    private String telFormat;

    @Override
    public void initialize(TelMatch telMatch) {
        required = telMatch.required();
        telFormat = telMatch.telFormat();
    }

    @Override
    public boolean isValid(String tel, ConstraintValidatorContext constraintValidatorContext) {
        return required ? match(tel) : true;
    }

    public boolean match(String tel) {
        return StringUtils.isNotBlank(tel) && Pattern.compile(telFormat).matcher(tel).matches();
    }
}
