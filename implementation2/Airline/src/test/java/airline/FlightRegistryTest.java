package airline;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class FlightRegistryTest {
    @Test
    void testReadingFromCsv() {
        FlightRegistry registry = new FlightRegistryImpl();

        List<Flight> flights = registry.getFlights();

        assertThat(flights).isNotEmpty();
        // There is a route from GRO to MST
        assertThat(flights).contains(new Flight("GRO", "MST"));

        // There is no route from AMS to MST
        assertThat(flights).doesNotContain(new Flight("AMS", "MST"));
    }
}
