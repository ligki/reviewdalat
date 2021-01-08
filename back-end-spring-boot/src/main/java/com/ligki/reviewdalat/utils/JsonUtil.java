package com.ligki.reviewdalat.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

public class JsonUtil {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    public static final String toJson(Object o) {
        if (ObjectUtils.isEmpty(o)) {
            return "";
        } else {
            try {
                return OBJECT_MAPPER.writeValueAsString(o);
            } catch (JsonProcessingException e) {
                LOGGER.info(e.getMessage());
                return "";
            }
        }
    }

}
