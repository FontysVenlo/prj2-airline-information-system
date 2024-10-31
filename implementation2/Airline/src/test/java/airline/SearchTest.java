package airline;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SearchTest {
    class TestFlightRegistry implements FlightRegistry {
        private List<Flight> flights;

        TestFlightRegistry(List<Flight> flights) {
            this.flights = flights;
        }

        public List<Flight> getFlights() {
            return flights;
        }
    }

    @Test
    void searchWithoutKnownFlightsReturnsEmptyList() {
        List<Flight> knownFlights = new ArrayList<>();
        FlightRegistry registry = new TestFlightRegistry(knownFlights);

        FlightSearch search = new FlightSearch(registry);
        List<Flight> results = search.search("AMS", "MST");

        assertThat(results).isEmpty();
    }

    @Test
    void searchReturnsMatchingFlights() {
        List<Flight> knownFlights = new ArrayList<>(
            List.of(
                // Match
                new Flight("GRO", "MST"),
                // No match
                new Flight("AMS", "MST")
            )
        );
        FlightRegistry registry = new TestFlightRegistry(knownFlights);

        FlightSearch search = new FlightSearch(registry);
        List<Flight> results = search.search("GRO", "MST");

        assertThat(results).containsExactly(
            new Flight("GRO", "MST")
        );
    }
}
