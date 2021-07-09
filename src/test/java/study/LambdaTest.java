package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUP() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void sumAllTest() {
        final int result = sumAll(numbers, number -> true);
        assertThat(result).isEqualTo(21);

    }

    @Test
    public void sumAllEvenTest() {
        final int result = sumAll(numbers, number -> number % 2 == 0);
        assertThat(result).isEqualTo(12);
    }

    @Test
    public void sumAllOverThreeTest() {
        final int result = sumAll(numbers, number -> number > 3);
        assertThat(result).isEqualTo(15);

    }

    private int sumAll(List<Integer> numbers, Predicate predicate) {
        int total = 0;
        for (int number : numbers) {
            if (predicate.test(number)) {
                total += number;
            }
        }
        return total;
    }

//    private int sumAllEven(List<Integer> numbers, Predicate predicate) {
//        int total = 0;
//        for (int number : numbers) {
//            if (number % 2 == 0){
//                if (predicate.test(number)) {
//                    total += number;
//                }
//            }
//        }
//        return total;
//    }



    /*
    public int sumAll(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;

        }
        return total;
    }

    public int sumAllEven(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            if (number % 2 ==0) {
                total += number;
            }
        }
        return total;
    }
    */
//
//    public int sumAllOverThree(List<Integer> numbers) {
//        int total = 0;
//        for (int number : numbers) {
//            if (number > 3) {
//                total += number;
//            }
//        }
//        return total;
//    }

}
