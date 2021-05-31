package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }


    @Test
    void sumAll() {
        final int result = numbers.stream()
                .mapToInt(number -> number)
                .sum();

        assertThat(result).isEqualTo(21);
    }

    @Test
    void sumAllEven() {
        final int result = numbers.stream()
                .mapToInt(number -> number)
                .filter(number -> number % 2 == 0)
                .sum();

        assertThat(result).isEqualTo(12);
    }

    @Test
    void sumAllOverThree() {
        final int result = numbers.stream()
                .mapToInt(number -> number)
                .filter(number -> number > 3)
                .sum();

        assertThat(result).isEqualTo(15);
    }

    @Test
    void sumAllDouble() {
        final int result = numbers.stream()
                .mapToInt(number -> number * 2)
                .sum();

        assertThat(result).isEqualTo(42);
    }

    @Test
    void doubleList() {
        final List<Integer> actual = numbers.stream()
                .map(number -> number * 2)
                .collect(Collectors.toList());

        assertThat(actual).containsExactly(2, 4, 6, 8, 10, 12);
    }

    @Test
    void sumDoubleOverThree() {
        final Integer actual = numbers.stream()
                .filter(number -> number > 3)
                .map(number -> number * 2)
                .reduce(0, (number1, number2) -> number1 + number2);

        assertThat(actual).isEqualTo(30);
    }

}
