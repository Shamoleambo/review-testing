package com.tidz.review_testing.http;

public class ApiResponse {

    private String message;
    private Object body;

    public ApiResponse(String message, Object body) {
        this.message = message;
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
