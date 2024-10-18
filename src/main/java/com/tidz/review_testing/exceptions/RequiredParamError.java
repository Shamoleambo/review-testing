package com.tidz.review_testing.exceptions;

public class RequiredParamError extends RuntimeException {

    public RequiredParamError(String message) {
        super(message);
    }
}
