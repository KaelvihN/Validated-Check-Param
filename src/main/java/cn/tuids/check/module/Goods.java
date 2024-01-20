package cn.tuids.check.module;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tuids
 * @date 2024/1/20 19:18
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    @Size(min = 1, max = 16, message = "商品名称长度为1~16")
    @NotBlank(message = "商品名称不能为空")
    private String name;
    @DecimalMin(value = "0", message = "价格不能为0")
    private String price;
}
