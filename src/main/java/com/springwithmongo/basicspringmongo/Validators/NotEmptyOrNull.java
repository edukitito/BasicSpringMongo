package com.springwithmongo.basicspringmongo.Validators;

import jakarta.validation.Constraint;

import java.lang.annotation.*;
import jakarta.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotEmptyOrNullValidator.class)
@Documented
public @interface NotEmptyOrNull {
    String message() default "Field must not be null or empty";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}