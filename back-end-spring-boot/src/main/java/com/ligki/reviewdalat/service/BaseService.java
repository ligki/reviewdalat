package com.ligki.reviewdalat.service;

import com.ligki.reviewdalat.constant.ErrorCode;
import com.ligki.reviewdalat.exception.ApiException;
import com.ligki.reviewdalat.utils.Condition;
import com.ligki.reviewdalat.utils.ObjectValidator;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseService.class);

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Autowired
    ObjectValidator validator;

    protected static final String BLANK_STRING = "";

    protected static final int LIMIT_PAGE = 10;

    /**
     * Validate an object using @annotations in fields
     *
     * @param t object to validate
     * @return blank string if valid
     */
    protected String validateRequestThenReturnMsg(Object t) {
        return validator.validateThenReturnMessage(t);
    }

    /**
     * Validate a string with condition
     *
     * @param param          string to validate
     * @param condition      condition
     * @param invalidMessage expect message when not valid
     * @return return blank string if valid
     */
    protected String validateParameterThenReturnMsg(String param, Condition condition, String invalidMessage) {
        return condition.isValid(param) ? "" : invalidMessage;
    }

    protected void validateErrorMsg(String errorMsg) {
        if (!BLANK_STRING.equals(errorMsg))
            throw new ApiException(ErrorCode.E0002, errorMsg);
    }
}
