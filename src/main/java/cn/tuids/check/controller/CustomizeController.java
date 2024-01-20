package cn.tuids.check.controller;

import cn.tuids.check.config.Result;
import cn.tuids.check.config.TelMatch;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tuids
 * @date 2024/1/21 2:48
 */

@RestController
@RequestMapping("customize")
public class CustomizeController {

    @GetMapping("telFormat")
    public Result telFormat(@RequestParam @Validated @TelMatch String tel) {
        return Result.success("=>86+" + tel);
    }
}