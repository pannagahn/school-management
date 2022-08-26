package com.school.app.data.payload.response;

public class StudentResponse {
    private String message;

    public StudentResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
