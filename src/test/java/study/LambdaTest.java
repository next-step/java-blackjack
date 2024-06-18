package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

class LambdaTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = List.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    void sumAll() {
        final int result = sumAll(numbers, number -> true);
        assertThat(result).isEqualTo(21);
    }

    @Test
    void sumOverThree() {
        final int result = sumAll(numbers, number -> (int) number > 3);
        assertThat(result).isEqualTo(15);
    }

    @Test
    void sumAllEven() {
        final int result = sumAll(numbers, number -> (double) number > 3.5);
        assertThat(result).isEqualTo(12);
    }

    private int sumAll(List<Integer> numbers, Conditional conditional) {
        return numbers.stream().filter(number -> conditional.test(number)).reduce(0, Integer::sum);
    }

    interface Conditional {
        boolean test(Number a);
    }


}
