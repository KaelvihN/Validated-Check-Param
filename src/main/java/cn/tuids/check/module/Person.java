package cn.tuids.check.module;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

/**
 * @author tuids
 * @date 2024/1/20 15:29
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @NotBlank
    private String name;
    @NotNull
    private Character sex;
    @AssertTrue
    private Boolean flag;
    @FutureOrPresent
    private Calendar day;

}
