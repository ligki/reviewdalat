package com.ligki.reviewdalat.utils;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class ObjectValidator {

    /**
     * Validate an Object using ConstraintViolation, message from message()
     *
     * @param t   object to validate
     * @param <T> Type
     * @return all messages as string
     */
    public <T> String validateThenReturnMessage(T t) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(t);
        List<String> messages = new ArrayList<>();
        for (ConstraintViolation<T> violation : violations) {
            messages.add(violation.getMessage());
        }
        String message = String.join(", ", messages);
        return message;
    }
}
