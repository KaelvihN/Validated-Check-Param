package cn.tuids.check.controller;

import cn.tuids.check.config.Result;
import cn.tuids.check.module.GroupA;
import cn.tuids.check.module.GroupI;
import cn.tuids.check.module.Shop;
import jakarta.validation.groups.Default;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tuids
 * @date 2024/1/20 20:45
 */
@RestController
@RequestMapping("shop")
public class ShopController {
    @PostMapping("group")
    public Result group(@RequestBody @Validated(value = {GroupA.class, Default.class}) Shop shop) {
        return Result.success(shop);
    }

    @PostMapping("sort")
    public Result sort(@RequestBody @Validated(value = {GroupI.class}) Shop shop) {
        return Result.success(shop);
    }

    @PostMapping("recursion")
    public Result recursion(@RequestBody @Validated(value = {GroupI.class}) Shop shop) {
        return Result.success(shop);
    }
}