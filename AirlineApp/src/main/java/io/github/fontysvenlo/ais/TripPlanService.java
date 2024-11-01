package io.github.fontysvenlo.ais;

import java.util.ArrayList;
import java.util.List;

public class TripPlanService {
    FlightRouteRegistry flightRegistry;

    public TripPlanService(FlightRouteRegistry flightRegistry) {
        this.flightRegistry = flightRegistry;
    }

    public List<FlightRoute> searchRoute(String fromAirport, String toAirport) {
        List<FlightRoute> matchingFlights = new ArrayList<>();
        for (FlightRoute flight : flightRegistry.getFlights()) {
            if (flight.source().equals(fromAirport) && flight.destination().equals(toAirport)) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }
}
