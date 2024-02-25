package com.zerek.bigevent.annotation;

import com.zerek.bigevent.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.FIELD;

@Documented
@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
// 元注解
@Constraint(validatedBy = {StateValidation.class})
public @interface State {
    // error message
    String message() default "state should be published or draft";
    // specified group
    Class<?>[] groups() default {};
    // payload get state annotation info
    Class<? extends Payload>[] payload() default {};
}
