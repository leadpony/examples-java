package org.example;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class LongResponseController {

    private final JsonFactory jsonFactory;

    public LongResponseController() {
        this.jsonFactory = new JsonFactory();
        this.jsonFactory.setCodec(new ObjectMapper());
    }

    @RequestMapping("/")
    public void returnLongResponse(HttpServletResponse response) {
        try (JsonGenerator generator = jsonFactory.createGenerator(response.getOutputStream())) {
            generator.writeStartObject();
            generator.writeFieldName("people");
            generator.writeStartArray();

            for (int i = 1; i < 10000; i++) {
                Person person = new Person(i, "John", "Smith", 46);
                generator.writeObject(person);
                sleep(2500);
            }

            generator.writeEndArray();
            generator.writeEndObject();
            generator.flush();
        } catch (IOException e) {
            System.out.println("IOException has occurred.");
        }
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
