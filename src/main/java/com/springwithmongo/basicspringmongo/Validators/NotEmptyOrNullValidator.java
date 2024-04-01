package com.springwithmongo.basicspringmongo.Validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotEmptyOrNullValidator implements ConstraintValidator<NotEmptyOrNull, CharSequence> {
    @Override
    public void initialize(NotEmptyOrNull constraintValidator){}

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        return charSequence != null && !charSequence.toString().trim().isEmpty();
    }
}
