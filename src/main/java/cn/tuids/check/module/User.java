package cn.tuids.check.module;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tuids
 * @date 2024/1/17 20:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotNull(message = "id不能为空")
    @Min(value = 1, message = "id必须大于0")
    private Integer id;
    @NotBlank(message = "名称不能为空")
    @Size(min = 1, max = 16, message = "名字长度在1~16")
    private String name;
    @Email(groups = {GroupB.class})
    private String email;
    @Min(value = 0)
    @Max(200)
    private Integer age;
    @Pattern(regexp = "^[1][3,4,5,7,8,9][0-9]{9}$", message = "输入的手机号不合法", groups = {GroupA.class})
    private String tel;
    @DecimalMin(value = "0", message = "薪资不能低于0")
    @DecimalMax(value = "100000000000", message = "您已达到最高薪资")
    private Double salary;

}
