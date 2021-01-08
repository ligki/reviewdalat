package com.ligki.reviewdalat.controller;

import com.ligki.reviewdalat.constant.ErrorCode;
import com.ligki.reviewdalat.model.httpentity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {


    /**
     * To common response for APIs
     * If object response null, return ResponseEntity with HttpStatus NO_CONTENT and response body
     * as ErrorResponse E0001
     * @param response response object
     * @return response of APIs
     */
    protected ResponseEntity<?> handleResponse(Object response) {
        if (response == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ErrorResponse(ErrorCode.E0001, ErrorCode.E0001_MESSAGE));
        } else {
            return ResponseEntity.ok(response);
        }
    }
}
