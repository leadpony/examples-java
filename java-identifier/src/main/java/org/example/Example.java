package org.example;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Example {

    public static void main(String[] args) {
        try (OutputStream os = Files.newOutputStream(Paths.get("output.txt"));
             Writer writer = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            for (int cp = '\u0020'; cp <= '\uffff'; cp++) {
                if (!Character.isJavaIdentifierPart(cp)) {
                    writer.write(String.format("U+%04X: %c\n", cp, cp));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
