package org.example.parser;

import java.util.Map;

public interface DataParser {
    Map<String, String> parse(String inputFile);
}
