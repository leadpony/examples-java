package org.example;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class FileProxyDeserializer extends JsonDeserializer<FileProxy> {
    
    private static final Path tempDir = Paths.get(System.getProperty("java.io.tmpdir"));
    
    public FileProxyDeserializer() {
    }

    @Override
    public FileProxy deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Path tempPath = Files.createTempFile(tempDir, null, null);
        try (OutputStream out = Files.newOutputStream(tempPath)) {
            parser.readBinaryValue(Base64Variants.MIME, out);
        }
        return new FileProxyImpl(tempPath);
    }

    private static class FileProxyImpl implements FileProxy {
        
        private final Path path;
        
        FileProxyImpl(Path path) {
            this.path = path;
        }

        @Override
        public long getSize() {
            try {
                return Files.size(path);
            } catch (IOException e) {
                return 0;
            }
        }

        @Override
        public void transferTo(File file) throws IOException {
            Files.copy(path, file.toPath());
        }
    }
}
