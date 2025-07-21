package es.cic25.proyectoconjunto.proyectoConjunto.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import es.cic25.proyectoconjunto.proyectoConjunto.controller.ModificacionSecurityException;

@RestControllerAdvice
public class MyControllerAdvice {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ModificacionSecurityException.class})
    public void controloModificaion() {

    }
}
