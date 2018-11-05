package org.example;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using=FileProxyDeserializer.class)
public interface FileProxy {
    
    long getSize();

    void transferTo(File file) throws IOException;
}
