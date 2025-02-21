package com.example.demo.controller;

import com.example.demo.dto.response.ExceptionResponse;
import com.example.demo.exception.RuleException;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class exceptionController {


    private final MessageSourceAccessor messageSourceAccessor;

    public exceptionController(MessageSourceAccessor messageSourceAccessor) {
        this.messageSourceAccessor = messageSourceAccessor;
    }

    @ExceptionHandler(RuleException.class)
    public ResponseEntity<List<ExceptionResponse>> handlerRuleException(RuleException ruleException) {

        return ResponseEntity.status(400).body(Collections.singletonList(ruleExceptionToExceptionResponse(ruleException)));

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionResponse>> MethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {

        return ResponseEntity.status(402)
                .body(methodArgumentNotValidExceptionToExceptionResponse(methodArgumentNotValidException));

    }

    private List<ExceptionResponse> methodArgumentNotValidExceptionToExceptionResponse(MethodArgumentNotValidException methodArgumentNotValidException) {

        return methodArgumentNotValidException.getFieldErrors().stream().map(error->new ExceptionResponse(
                error.getDefaultMessage(),error.getField()
        )).collect(Collectors.toList());

    }

    private ExceptionResponse ruleExceptionToExceptionResponse(RuleException ruleException) {
        return new ExceptionResponse(messageSourceAccessor.getMessage(ruleException.getMessage()),messageSourceAccessor.getMessage( ruleException.getMessage()));

    }
}
