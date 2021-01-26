package com.ligki.reviewdalat.service;

import com.ligki.reviewdalat.constant.ErrorCode;
import com.ligki.reviewdalat.exception.ApiException;
import com.ligki.reviewdalat.utils.Condition;
import com.ligki.reviewdalat.utils.ObjectValidator;
import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

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

    protected int mapPageToPageable(String page) {
        if (ObjectUtils.isEmpty(page) || !StringUtils.isNumeric(page)) {
            return 0;
        } else {
            int pageInt = Integer.parseInt(page);
            if (pageInt < 1) return 0;
            else return pageInt - 1;
        }
    }

    protected int mapPageToOffset(String page) {
        if (ObjectUtils.isEmpty(page) || !StringUtils.isNumeric(page)) {
            return 0;
        } else {
            int pageInt = Integer.parseInt(page);
            if (pageInt < 1) return 0;
            else return (pageInt - 1) * LIMIT_PAGE;
        }
    }
}
