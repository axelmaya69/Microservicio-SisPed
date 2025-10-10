package com.example.Auth_service.exceptions;


import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.nio.file.AccessDeniedException;
import java.security.SignatureException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleSecurityException(Exception exception){
        ProblemDetail errorDetail = null;

        exception.printStackTrace();

        if(exception instanceof BadCredentialsException){
            errorDetail= ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(401),exception.getMessage());
            errorDetail.setProperty("Descripcion","El usuario o contraseña es incorrecto");

            return errorDetail;
        }

        if (exception instanceof AccountStatusException){
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), exception.getMessage());
            errorDetail.setProperty("Descripcion","La cuenta está bloqueada");

            return errorDetail;
        }

        if(exception instanceof AccessDeniedException){
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403),exception.getMessage());
            errorDetail.setProperty("Descripcion","No tienes autorizacion para acceder a este recurso");

            return errorDetail;
        }

        if (exception instanceof SignatureException){
            errorDetail= ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), exception.getMessage());
            errorDetail.setProperty("Descripcion","La firma JWT es inválida");

            return errorDetail;
        }

        if (exception instanceof ExpiredJwtException){
            errorDetail= ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403),exception.getMessage());
            errorDetail.setProperty("Descripcion","El token ha expirado");

            return errorDetail;
        }

        if (errorDetail == null){
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500),exception.getMessage());
            errorDetail.setProperty("Descripcion","Error interno del servidor desconocido");
        }

        return errorDetail;
    }
}
