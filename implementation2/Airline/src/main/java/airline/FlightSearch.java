package airline;

import java.util.ArrayList;
import java.util.List;

public class FlightSearch {
    private FlightRegistry flightRegistry;

    public FlightSearch(FlightRegistry flightRegistry) {
        this.flightRegistry = flightRegistry;
    }

    public List<Flight> search(String fromAirport, String toAirport) {
        List<Flight> matchingFlights = new ArrayList<>();

        for (Flight flight : flightRegistry.getFlights()) {
            if (flight.source().equals(fromAirport) && flight.destination().equals(toAirport)) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }
}
