package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTest {
    @Test
    void name() {
        final Optional<String> mabeName = Optional.ofNullable("soyeon");
        final Car car = mabeName.map(name -> new Car(name, 0)) // mabeName이 null이 아니라면 정상적으로 car을 생성함.아닐경우
                .orElse(new Car("name", 0));//orElse 가 하는일 : 만약에 null이면 return해라
        Assertions.assertThat(mabeName).isEqualTo("soyeon");
    }
}
