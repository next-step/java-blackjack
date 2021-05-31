package study;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalTest {
    @Test
    public void name() {
        final Optional<String> maybeName = Optional.ofNullable("ssung");
        // maybeName이 null이면 map도 null임
        // maybeName이 null이 아니면 map Car
        final Car actual = maybeName.map(name -> new Car(name,0))
                .orElse(new Car("test",0));
        assertThat(actual.getName()).isEqualTo("ssung");
    }

    @Test
    public void name2() {
        final Optional<String> maybeName = Optional.ofNullable(null);
        // maybeName이 null이면 map도 null임
        // maybeName이 null이 아니면 map Car
        final Car actual = maybeName.map(name -> new Car(name,0))
                .orElse(new Car("test",0));
        assertThat(actual.getName()).isEqualTo("test");
    }
}
