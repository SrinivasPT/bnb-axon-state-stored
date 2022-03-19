package com.edge.bnb.command.infra.error;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor
public class ErrorResponse {

    public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
        this.stackTrace = null;
    }

    public ErrorResponse(String message, List<String> details, String stackTrace) {
        super();
        this.message = message;
        this.details = details;
        this.stackTrace = stackTrace;
    }

    //General error message about nature of error
    private String message;

    //Specific errors in API request processing
    private List<String> details;

    private String stackTrace;
}
