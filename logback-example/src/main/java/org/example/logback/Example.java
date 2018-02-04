package org.example.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example {
    
    private static final Logger log = LoggerFactory.getLogger(Example.class);
    
    public void run() {
        log.info("Starting example application.");
        log.debug("This is a debugging message.");
    }

    public static void main(String[] args) {
        new Example().run();
    }
}
