package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void sumAll() {
        final int result = numbers.stream()
                .mapToInt(number -> number)//Integer -> int
                .sum();
        assertThat(result).isEqualTo(21);
    }

    @Test
    public void sumAllEven() {
        final int result = numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number)//Integer -> int
                .sum();
        assertThat(result).isEqualTo(12);
    }

    @Test
    public void sumAllOverThree() {
        final int result = numbers.stream()
                .filter(number -> number > 3)
                .mapToInt(number -> number)//Integer -> int
                .sum();
        assertThat(result).isEqualTo(15);
    }

    @Test
    public void sumAllDouble() {
        final int result = numbers.stream()
                .mapToInt(number -> number * 2)//Integer -> int
                .sum();
        assertThat(result).isEqualTo(42);
    }

    @Test
    public void changeList() {
        final List<Integer> actual = numbers.stream()
                .map(number -> number * 2)//Integer -> int
                .collect(Collectors.toList());
        assertThat(actual).containsExactly(2, 4, 6, 8, 10, 12);
    }

    @Test
    public void sumAllOverThreeDouble() {
        final int result = numbers.stream()
                .filter(number -> number > 3)
                .mapToInt(number -> number * 2)
                .sum();
        assertThat(result).isEqualTo(30);
    }

    @Test
    public void sumAllOverThreeDouble2() {
        final int result = numbers.stream()
                .filter(number -> number > 3)
                .map(number -> number * 2)
                .reduce(0, Integer::sum);
                        //초기기값       과정들
        assertThat(result).isEqualTo(30);
    }
}


