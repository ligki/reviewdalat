package com.ligki.reviewdalat.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;

@Component
public class ErrorCode {
    public static String SUCCESS;
    public static String SUCCESS_MESSAGE;
    public static String E0001;
    public static String E0001_MESSAGE;

    @Autowired
    public void setFieldsFromProperties(Environment env) throws IllegalAccessException {
        for (Field f : ErrorCode.class.getDeclaredFields()) {
            f.setAccessible(true);
            f.set(null, env.getProperty(getPropertyName(f.getName())));
        }
    }

    private String getPropertyName(String upperHyphenString) {
        if (ObjectUtils.isEmpty(upperHyphenString)) {
            return null;
        } else {
            return upperHyphenString.toLowerCase().replace("_", ".");
        }

    }

}
