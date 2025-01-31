package io.github.fontysvenlo.ais.restapinomodule;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UnitTest {
    @Test
    public void test() {
        System.out.println("Test");
        assertThat(true).isTrue();
    }

    @Test
    public void test2() {
        assertThat(false).isFalse();
    }
}
