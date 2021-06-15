package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    private List<Integer> numbers;


    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    void sumAll() {
        final int result = numbers.stream()
                .mapToInt(number -> Integer.valueOf(number))
                .sum();
        Assertions.assertThat(result).isEqualTo(21);
    }

    @Test
    void sumAllEven() {
        final int result = numbers.stream()
                .mapToInt(number -> number)
                .filter(number -> number % 2 == 0)
                .sum();
        Assertions.assertThat(result).isEqualTo(12);
    }

    @Test
    void sumAllOverThree() {
        final int result = numbers.stream()
                .mapToInt(number -> number)
                .filter(number -> number > 3)
                .sum();
        Assertions.assertThat(result).isEqualTo(15);
    }

    @Test
    void sumAllDouble() {
        final int result = numbers.stream()
                .mapToInt(number -> number * 2)
                .sum();
        Assertions.assertThat(result).isEqualTo(42);
    }

    @Test
    void collectors() {
        final List<Integer> actual = numbers.stream()
                .map(number -> number * 2)
                .collect(Collectors.toList());//컬렉션을 만들어줌 : 여러가지 컬렉션 중 하나를 만들수 있음
        Assertions.assertThat(actual).containsExactly(2, 4, 6, 8, 10, 12);
    }

    //3보보다 큰 숫자를 2배한후 모든값의 합
    @Test
    void mapToDouble() {
        final int result = numbers.stream()
                .filter(number -> number > 3)
                .mapToInt(number -> number * 2)
                .reduce(0, (number1, number2) -> number1 + number2);

        Assertions.assertThat(result).isEqualTo(30);
    }
}
