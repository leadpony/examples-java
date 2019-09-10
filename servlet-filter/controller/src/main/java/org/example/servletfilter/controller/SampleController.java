package org.example.servletfilter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    private static final Logger log = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping("/")
    @ResponseBody
    public String greeting() {
        log.info("greeting() was called");
        return "hello";
    }
}
