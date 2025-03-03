package com.ucompensar.tienda.controller;

import com.ucompensar.tienda.controller.exception.PersonalException;
import com.ucompensar.tienda.controller.exception.UserNotFoundException;
import com.ucompensar.tienda.controller.exception.UsernameAlreadyExistsException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(PersonalException.class)
    public ProblemDetail handlePersonalException(Exception ex, HttpServletRequest request) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), ex.getMessage());
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ProblemDetail handleNoResourceFoundException(Exception ex, HttpServletRequest request) {
        ProblemDetail response = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), ex.getMessage());
        response.setTitle(ex.getClass().getSimpleName());
        return response;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ProblemDetail handleUserNotFoundException(Exception ex, HttpServletRequest request) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), ex.getMessage());
    }

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ProblemDetail handleUsernameAlreadyExistsException(Exception ex, HttpServletRequest request) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400), ex.getMessage());
    }
}
