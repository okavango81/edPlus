package com.edplus.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalException {

    // captura o parametro passado na requisicao
    private String resourceRequest(String uri){
        Integer index = uri.lastIndexOf("/");
        String resource = uri.substring(index +1);
        return resource;
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ObjectException handlerNoSuchElementException(NoSuchElementException ex, HttpServletRequest request){

        String message = String.format("resource %s not found", resourceRequest(request.getRequestURI()));
        return new ObjectException(request.getRequestURI(), request.getMethod(), HttpStatus.NOT_FOUND.value(),message);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ObjectException handlerNoResourceFoundException(NoResourceFoundException ex, HttpServletRequest request){

        String message = "malformed request syntax";
        return new ObjectException(request.getRequestURI(), request.getMethod(), HttpStatus.BAD_REQUEST.value(),message);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ObjectException handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, HttpServletRequest request){

       String message = String.format("the %s parameter is incorrect for this request", resourceRequest(request.getRequestURI()));
        return new ObjectException(request.getRequestURI(), request.getMethod(), HttpStatus.BAD_REQUEST.value(),message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ObjectException handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request){

        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(error -> String.format("%s: %s", error.getField(),error.getDefaultMessage())).collect(Collectors.toList());
        String message = "unable to process the content contained in the instruction";
        return  new ObjectException(request.getRequestURI(), request.getMethod(), HttpStatus.UNPROCESSABLE_ENTITY.value(),message, errors);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ObjectException handlerDataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request){

        String message = "name/title already registered in the database";
        return new ObjectException(request.getRequestURI(), request.getMethod(), HttpStatus.CONFLICT.value(),message);

    }

}
