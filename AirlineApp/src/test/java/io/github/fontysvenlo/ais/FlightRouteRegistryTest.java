package io.github.fontysvenlo.ais;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class FlightRouteRegistryTest {
    @Test
    void testReadingFromCsv() {
        FlightRouteRegistry registry = new FlightRouteRegistryImpl();

        List<FlightRoute> flights = registry.getFlights();

        assertThat(flights)
            .isNotEmpty()
            .contains(new FlightRoute("GRO", "MST"))
            .doesNotContain(new FlightRoute("AMS", "MST"));
    }

    @Test
    void testOnlyReadsCsvOnce() {
        FlightRouteRegistry registry = new FlightRouteRegistryImpl();

        List<FlightRoute> flights = registry.getFlights();
        List<FlightRoute> flights2 = registry.getFlights();

        assertThat(flights).isSameAs(flights2);
    }
}
