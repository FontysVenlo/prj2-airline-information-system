package io.github.fontysvenlo.ais;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.sun.net.httpserver.Request;

class RequestHelperTest {

    @Nested
    class ParsingQueryParameters {
        @Test
        void emptyQueryReturnsEmptyMap() {
            Map<String, String> params = RequestHelper.queryParams(URI.create("http://localhost:1234"));

            assertThat(params).isEmpty();
        }

        @Test
        void queryReturnsMappedParamters() {
            Map<String, String> params = RequestHelper.queryParams(URI.create("http://localhost:1234?foo=bar&baz=qux"));

            assertThat(params)
                .containsEntry("foo", "bar")
                .containsEntry("baz", "qux");
        }
    }
}
