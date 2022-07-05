package com.example.demo.exception;

/*
 * @author: Cristian Plazas
 * @since 6/4/2022
 * @version: 1.0
 */

/*
 * Clase para manejar las excepciones de la aplicacion.
 */
public class MyException extends Exception {

        /*
     * Constructor de la clase.
     * 
     * Ingresa un mensaje de error.
     */
    public MyException(String message) {
        super(message);
    }
}
