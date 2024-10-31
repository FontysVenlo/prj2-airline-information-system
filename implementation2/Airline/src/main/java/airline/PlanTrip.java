package airline;

import java.util.ArrayList;
import java.util.List;

public class PlanTrip {
    FlightRouteRegistry flightRegistry;

    public PlanTrip(FlightRouteRegistry flightRegistry) {
        this.flightRegistry = flightRegistry;
    }

    public List<FlightRoute> search(String fromAirport, String toAirport) {
        List<FlightRoute> matchingFlights = new ArrayList<>();
        for (FlightRoute flight : flightRegistry.getFlights()) {
            if (flight.source().equals(fromAirport) && flight.destination().equals(toAirport)) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }
}
