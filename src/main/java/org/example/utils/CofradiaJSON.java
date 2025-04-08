package org.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.CofradiaWrapper;

import java.io.File;
import java.io.IOException;

public class CofradiaJSON {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void serializarAJson(CofradiaWrapper cofradiaWrapper, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), cofradiaWrapper);
    }

    public static CofradiaWrapper deserializarDesdeJson(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), CofradiaWrapper.class);
    }
}
