package airline;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class FlightRouteRegistryTest {
    @Test
    void testReadingFromCsv() {
        FlightRouteRegistry registry = new FlightRouteRegistryImpl();

        List<FlightRoute> flights = registry.getFlights();

        assertThat(flights).isNotEmpty();
        // There is a route from GRO to MST
        assertThat(flights).contains(new FlightRoute("GRO", "MST"));

        // There is no route from AMS to MST
        assertThat(flights).doesNotContain(new FlightRoute("AMS", "MST"));
    }

    @Test
    void testOnlyReadsCsvOnce() {
        FlightRouteRegistry registry = new FlightRouteRegistryImpl();

        List<FlightRoute> flights = registry.getFlights();
        List<FlightRoute> flights2 = registry.getFlights();

        assertThat(flights).isSameAs(flights2);
    }
}
