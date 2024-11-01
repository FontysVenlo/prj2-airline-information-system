package io.github.fontysvenlo.ais;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8001), 0);
        server.createContext("/", new RootHandler());
        server.createContext("/api/trip/search", new TripPlanSearchHandler());
        server.setExecutor(null); // Creates a default executor
        server.start();
        System.out.println("Server started on port 8001");
    }

    static class TripPlanSearchHandler implements HttpHandler {
        TripPlanService tripPlanService = new TripPlanService(new FlightRouteRegistryImpl());

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Map<String, String> queryParams = RequestHelper.queryParams(exchange.getRequestURI());
            String fromAirport = queryParams.get("from");
            String toAirport = queryParams.get("to");

            List<FlightRoute> flights = tripPlanService.searchRoute(fromAirport, toAirport);

            RequestHelper.respondJson(exchange, flights);
        }
    }

    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // TODO: this could be serving static files (html, js, css, png) instead

            String response = "Hello, World!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}