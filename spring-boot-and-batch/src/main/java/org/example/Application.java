package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        if (!checkArguments(args)) {
            System.exit(1);
        }
        int exitCode = SpringApplication.exit(SpringApplication.run(
                Application.class, args)); 
        System.exit(exitCode);
    }
    
    private static boolean checkArguments(String[] args) {
        ApplicationArguments arguments = new DefaultApplicationArguments(args);
        if (!arguments.containsOption("foo") || arguments.getOptionValues("foo").isEmpty()) {
            log.error("foo is missing");
            return false;
        }
        if (!arguments.containsOption("bar") || arguments.getOptionValues("bar").isEmpty()) {
            log.error("bar is missing");
            return false;
        }
        return true;
    }
}
