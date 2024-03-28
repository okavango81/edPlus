package com.edplus.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.NoSuchElementException;

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


}
