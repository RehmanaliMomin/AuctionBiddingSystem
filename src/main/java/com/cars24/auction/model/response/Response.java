package com.cars24.auction.model.response;

public class Response {

    boolean status;
    String message;
    Object responseObject;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
    }

    @Override
    public String toString() {
        return "Response [status=" + status + ", message=" + message + ", responseObject=" + responseObject
                + "]";
    }
}

