package com.ligki.reviewdalat.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ligki.reviewdalat.constant.ErrorCode;
import com.ligki.reviewdalat.model.httpentity.ErrorResponse;
import com.ligki.reviewdalat.utils.JsonUtil;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@CrossOrigin
public abstract class BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    /**
     * To common response for APIs
     * If object response null, return ResponseEntity with HttpStatus NO_CONTENT and response body
     * as ErrorResponse E0001
     *
     * @param response response object
     * @return response of APIs
     */
    protected ResponseEntity<?> handleResponse(Object response) {
        String url = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getRequestURL().toString();
        logger.info("Response from {}: {}", url, JsonUtil.toJson(response));
        if (response == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ErrorResponse(ErrorCode.E0001, ErrorCode.E0001_MESSAGE));
        } else {
            return ResponseEntity.ok(response);
        }
    }
}
