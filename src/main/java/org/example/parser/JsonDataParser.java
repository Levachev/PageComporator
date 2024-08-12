package org.example.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class JsonDataParser implements DataParser{
    @Override
    public Map<String, String> parse(String inputFile) {
        try (FileReader fileReader = new FileReader(inputFile)){
            Gson gson = new Gson();
            return gson.fromJson(fileReader, new TypeToken<Map<String, Object>>() {
            }.getType());
        } catch (IOException e){
            return null;
        }
    }
}
