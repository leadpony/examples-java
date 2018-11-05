package org.example;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    
    @PostMapping(value="/", consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String postPicture(@RequestBody Picture picture) throws IOException {
        return "success";
    }
}
