package utils;

import java.util.HashMap;
import java.util.Map;

public class Headers {
    public static Map<String, String> headers() {
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json");
        header.put("Access-Control-Allow-Origin", "*");
        header.put("Access-Control-Allow-Headers", "*");
        header.put("Access-Control-Allow-Methods", "OPTIONS,POST,GET");
        return header;
    }
}
