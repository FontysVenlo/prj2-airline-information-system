package airline;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PlanTripTest {
    class TestFlightRegistry implements FlightRouteRegistry {
        private List<FlightRoute> flights;

        TestFlightRegistry(List<FlightRoute> flights) {
            this.flights = flights;
        }

        public List<FlightRoute> getFlights() {
            return flights;
        }
    }

    @Test
    void searchWithoutKnownFlightsReturnsEmptyList() {
        List<FlightRoute> knownFlights = new ArrayList<>();
        FlightRouteRegistry registry = new TestFlightRegistry(knownFlights);

        List<FlightRoute> results = new PlanTrip(registry).search("AMS", "MST");

        assertThat(results).isEmpty();
    }

    @Test
    void searchReturnsMatchingFlights() {
        List<FlightRoute> knownFlights = new ArrayList<>(
            List.of(
                // Match
                new FlightRoute("GRO", "MST"),
                // No match
                new FlightRoute("AMS", "MST"),
                new FlightRoute("MST", "MST"),
                new FlightRoute("GRO", "SFO"),
                new FlightRoute("LAX", "SFO")
            )
        );
        FlightRouteRegistry registry = new TestFlightRegistry(knownFlights);

        List<FlightRoute> results = new PlanTrip(registry).search("GRO", "MST");

        assertThat(results).containsExactly(
            new FlightRoute("GRO", "MST")
        );
    }

    @Test
    void tripToSelfReturnNothing() {
        List<FlightRoute> knownFlights = new ArrayList<>(
            List.of(
                new FlightRoute("GRO", "MST"),
                new FlightRoute("MST", "GRO")
            )
        );
        FlightRouteRegistry registry = new TestFlightRegistry(knownFlights);

        List<FlightRoute> results = new PlanTrip(registry).search("MST", "MST");

        assertThat(results).isEmpty();
    }
}
