package io.github.fontysvenlo.ais;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;

public class RequestHelper {
    private RequestHelper() {}

    public static Map<String, String> queryParams(URI url) {
        Map<String, String> params = new HashMap<>();
        String query = url.getQuery();
        if (query == null) {
            return params;
        }

        String[] pairs = query.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            try {
                params.put(
                    URLDecoder.decode(pair.substring(0, idx), "UTF-8"),
                    URLDecoder.decode(pair.substring(idx + 1), "UTF-8")
                );
            } catch(UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return params;
    }

    public static void respondJson(HttpExchange exchange, Object object) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(object);
        respondJson(exchange, jsonResponse);
    }

    public static void respondJson(HttpExchange exchange, String jsonResponse) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, jsonResponse.length());
        OutputStream os = exchange.getResponseBody();
        os.write(jsonResponse.getBytes());
        os.close();
    }
}
