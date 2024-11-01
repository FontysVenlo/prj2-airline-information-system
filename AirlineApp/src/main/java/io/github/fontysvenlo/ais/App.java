package io.github.fontysvenlo.ais;

// TODO: no com.sun, but jdk.httpserver
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Objects;

// TODO: integration test on server
public class App {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8001), 0);

        // from root, we serve the public resource directory
        Path publicResources = Paths.get(Objects.requireNonNull(App.class.getClassLoader().getResource("public").getPath()));
        server.createContext("/", SimpleFileServer.createFileHandler(publicResources));
        // API call
        server.createContext("/api/trip/search", new TripPlanSearchHandler());

        server.setExecutor(null); // Creates a default executor
        server.start();

        // Report ready
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
}