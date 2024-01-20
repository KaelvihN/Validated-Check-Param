package cn.tuids.check.controller;

import cn.tuids.check.config.Result;
import cn.tuids.check.module.Person;
import cn.tuids.check.module.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @author tuids
 * @date 2024/1/17 21:43
 */

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    /**
     * javaBean的校验 + RequestBody
     *
     * @param user
     * @return
     */
    @PostMapping("json")
    public Result jsonCheck(@Validated @RequestBody User user) {
        System.out.println("user = " + user);
        return Result.success(user);
    }

    /**
     * 基本类型的校验 + @RequestParam
     *
     * @param name
     * @param password
     * @param ids
     * @return
     */
    @PostMapping("from")
    public Result fromCheck(@NotBlank(message = "username not blank") @RequestParam(required = false) String name,
                            @Size(min = 6, max = 16, message = "password length in 6 to 16") @RequestParam String password,
                            @Size(min = 1, max = 8, message = "array size min is 1，max is 8") @RequestParam int[] ids) {
        StringBuilder res = new StringBuilder(name + password);
        Arrays.stream(ids).forEach(item -> res.append(item));
        return Result.success(res);
    }

    /**
     * javaBean的校验
     *
     * @param user
     * @return
     */
    @PostMapping
    public Result postCheck(@Validated User user) {
        System.out.println("user = " + user);
        return Result.success(user);
    }

    /**
     * 基本类型的校验 + @RequestParam
     *
     * @param name
     * @return
     */
    @GetMapping("param")
    public Result paramCheck(@Size(min = 1, max = 5, message = "name长度必须在1~5之间") @RequestParam(value = "name") String name) {
        String nikiName = name.toUpperCase();
        return Result.success(nikiName);
    }

    /**
     * 基本数据类型的校验
     *
     * @param msg
     * @return
     */
    @GetMapping
    public Result getCheck(@Range(min = 1,max = 5) String msg) {
        return Result.success(msg);
    }

    /**
     * // {
     * //     "name":"Tuids",
     * //     "sex":"男"
     * // }
     *
     * @param person
     * @return
     */
    @PostMapping("person")
    public Result personCheck(@RequestBody  Person person) {
        return Result.success(person);
    }



}
