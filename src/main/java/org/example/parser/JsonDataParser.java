package org.example.parser;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JsonDataParser implements DataParser{
    @Override
    public Map<String, String> parse(String inputFile) {

        try (FileReader fileReader = new FileReader(inputFile)){

            Map<String, String> result = new HashMap<>();
            Gson gson = new Gson();

            Type userListType = new TypeToken<ArrayList<Page>>(){}.getType();

            List<Page> userArray = gson.fromJson(fileReader, userListType);
            userArray.forEach(page -> result.put(page.url, page.content));
            return result;
        } catch (IOException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    static class Page{
        public String url;
        public String content;
    }
}
