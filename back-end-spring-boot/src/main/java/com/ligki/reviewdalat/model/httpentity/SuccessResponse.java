package com.ligki.reviewdalat.model.httpentity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SuccessResponse {
    String success = "true";
    String message;
    Object data;

    public SuccessResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public SuccessResponse(String message) {
        this.message = message;
        this.data = new String("[]");
    }
}
