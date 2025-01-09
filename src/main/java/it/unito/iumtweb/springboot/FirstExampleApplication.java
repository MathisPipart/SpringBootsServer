package it.unito.iumtweb.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Spring Boot application.
 * This class is responsible for initializing and starting the application.
 */
@SpringBootApplication
public class FirstExampleApplication {

    /**
     * The main method that serves as the entry point of the application.
     * It starts the Spring Boot application by invoking the {@link SpringApplication#run(Class, String...)} method.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(FirstExampleApplication.class, args);
    }

}
