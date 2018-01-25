package me.srikavin.chatauth.web.dto.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResource {
    private int code;
    private String message;
    private List<FieldErrorResource> fieldErrors;

    public ErrorResource() {
    }

    public ErrorResource(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FieldErrorResource> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorResource> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}