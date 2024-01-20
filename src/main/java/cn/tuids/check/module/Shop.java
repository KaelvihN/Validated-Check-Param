package cn.tuids.check.module;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

/**
 * @author tuids
 * @date 2024/1/20 19:07
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Shop {
    @Size(min = 1, max = 16, message = "商店名称的名称长度为1-16", groups = {GroupA.class})
    @NotBlank(message = "商店名不能为空")
    private String name;
    @Min(value = 0, message = "收入不能低于0", groups = {GroupB.class})
    private Double income;
    @Email(message = "您输入的邮件格式不合法")
    private String email;
    @NotBlank(message = "地址不能为空", groups = {GroupA.class, GroupB.class})
    private String local;
    @Valid
    @NotNull(message = "商品列表不能为空")
    @Size(min = 1, message = "至少有一个商品")
    private List<Goods> goodsList;
}
