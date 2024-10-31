package airline;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import airline.dataconnections.CsvFile;

class FlightRegistryImpl implements FlightRegistry {
    private List<Flight> flights;

    FlightRegistryImpl() {
        this.flights = readFlights();
    }

    public List<Flight> getFlights() {
        return flights;
    }

    private static List<Flight> readFlights() {
        List<Flight> flights = new ArrayList<>();
        List<String[]> routesData = CsvFile.read("routes.csv");
        for (String[] route : routesData) {
            flights.add(new Flight(route[2], route[4]));
        }

        return flights;
    }
}
