package me.srikavin.chatauth.web;

import me.srikavin.chatauth.web.dto.error.ErrorResource;
import me.srikavin.chatauth.web.dto.error.FieldErrorResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ControllerAdvice
public class FieldExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ConstraintViolationException.class})
    protected ResponseEntity<Object> handleInvalidRequest(ConstraintViolationException e, WebRequest request) {
        List<FieldErrorResource> fieldErrorResources = new ArrayList<>();

        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            FieldErrorResource fieldErrorResource = new FieldErrorResource();
            Path.Node node = constraintViolation.getPropertyPath().iterator().next();
            fieldErrorResource.setResource(node.getName());
            fieldErrorResource.setField(constraintViolation.getPropertyPath().toString());
            fieldErrorResource.setMessage(constraintViolation.getMessage());
            fieldErrorResources.add(fieldErrorResource);
        }

        ErrorResource error = new ErrorResource(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        error.setFieldErrors(fieldErrorResources);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(e, error, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
    }
}
