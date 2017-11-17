package fr.paul.tChaton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
@SpringBootApplication(scanBasePackages = { "fr.iut.api" })
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}