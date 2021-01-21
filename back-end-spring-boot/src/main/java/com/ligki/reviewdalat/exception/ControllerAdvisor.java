package com.ligki.reviewdalat.exception;

import com.ligki.reviewdalat.constant.ErrorCode;
import com.ligki.reviewdalat.model.httpentity.ErrorResponse;
import com.ligki.reviewdalat.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ControllerAdvisor.class);

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Object> handleApiException(ApiException e, WebRequest webRequest) {
        ErrorResponse errorResponse = e.getErrorResponse();
        logger.info("Throws ApiException from {}: {}", ((ServletWebRequest) webRequest).getRequest().getRequestURI(), JsonUtil.toJson(errorResponse));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUnexpectException(Exception e, WebRequest webRequest) {
        logger.info("Throws ApiException from {}: {}", ((ServletWebRequest) webRequest).getRequest().getRequestURI(), e.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.E0001, ErrorCode.E0001_MESSAGE);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
