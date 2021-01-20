package com.ligki.reviewdalat.annotation.validation;

import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class MemberOfValidator implements
        ConstraintValidator<MemberOf, String> {
    String[] member;

    @Override
    public void initialize(MemberOf constraintAnnotation) {
        this.member = constraintAnnotation.accepted();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return (!ObjectUtils.isEmpty(member) && !ObjectUtils.isEmpty(value) && Arrays.asList(member).contains(value));
    }
}
