package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    void sumAllEven() {
        final int result = sumAll(numbers, number-> number % 2 == 0);
        assertThat(result).isEqualTo(12);
    }

    @Test
    void sumAllOverThree() {
        final int result = sumAll(numbers, number-> number > 3);
        assertThat(result).isEqualTo(15);
    }

    private int sumAll(List<Integer> numbers, Predicate<Integer> conditional) {
        return numbers.stream()
                .filter(conditional)
                .reduce(0, Integer::sum);
//        int total = 0;
//        for (int number : numbers) {
//            if(conditional.test(number)){
//                total += number;
//            }
//        }
//        return total;
    }
}