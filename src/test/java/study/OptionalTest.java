package study;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalTest {
    @Test
    public void name(){
        final Optional<String> maybeName = Optional.ofNullable("bin");
        final Car actual =
        maybeName.map(name -> new Car(name,0))
                .orElse(new Car("test",0));
        assertThat(actual.getName()).isEqualTo("bin");
    }

    @Test
    public void nameNull(){
        final Optional<String> maybeName = Optional.ofNullable(null);
        final Car actual =
                maybeName.map(name -> new Car(name,0))
                        .orElse(new Car("test",0));
        assertThat(actual.getName()).isEqualTo("test");
    }
}
