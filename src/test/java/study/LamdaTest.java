package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LamdaTest {

    List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    void sumAll() {
        final int result = sumAll(numbers, number -> true);
        Assertions.assertThat(result).isEqualTo(21);
    }

    @Test
    void sumAllEven() {
        final int result = sumAll(numbers, integer -> integer % 2 == 0);
        Assertions.assertThat(result).isEqualTo(12);
    }

    @Test
    void sumAllOverThree() {
        final int result = sumAll(numbers, integer -> integer > 3);
        Assertions.assertThat(result).isEqualTo(15);
    }

    public int sumAll(List<Integer> numbers, Predicate<Integer> predicate) {
        int total = 0;
        for (int number : numbers) {
            if (predicate.test(number)) {
                total += number;
            }
        }
        return total;
    }

}
