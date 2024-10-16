package com.tidz.review_testing.exceptions;

public class ResourceNotFoundError extends RuntimeException {

    public ResourceNotFoundError(String message) {
        super(message);
    }
}
