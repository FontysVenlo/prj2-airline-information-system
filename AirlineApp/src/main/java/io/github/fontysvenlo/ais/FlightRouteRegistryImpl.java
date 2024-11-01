package io.github.fontysvenlo.ais;

import java.util.ArrayList;
import java.util.List;

import io.github.fontysvenlo.ais.dataconnections.CsvFile;

class FlightRouteRegistryImpl implements FlightRouteRegistry {
    private List<FlightRoute> flights;

    FlightRouteRegistryImpl() {
        this.flights = readFlights();
    }

    public List<FlightRoute> getFlights() {
        return flights;
    }

    private static List<FlightRoute> readFlights() {
        List<FlightRoute> flights = new ArrayList<>();
        List<String[]> routesData = CsvFile.read("routes.csv");
        for (String[] route : routesData) {
            flights.add(new FlightRoute(route[2], route[4]));
        }

        return flights;
    }
}
