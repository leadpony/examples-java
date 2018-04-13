package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        int exitCode = SpringApplication.exit(SpringApplication.run(
                Application.class, args)); 
        System.exit(exitCode);
    }
}
