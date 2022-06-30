/**
 * Carpeta en la que se encuentran los archivos de la aplicacion.
 */
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase de inicialización de la aplicación.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2020
 */
@SpringBootApplication
public class DemoApplication {

	/**
	 * Método principal de la aplicación.
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
