package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class StreamTest {
    List<Integer> numbers;

    @BeforeEach
    public void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void sumAll() {
        final int result = numbers.stream()
                .mapToInt(number -> (int) number)
                .sum();

        assertThat(result).isEqualTo(21);
    }

    @Test
    public void sumAllEven() {
        final int result = numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> (int) number)
                .sum();

        assertThat(result).isEqualTo(12);
    }

    @Test
    public void sumAllOverThree() {
        final int result = numbers.stream()
                .filter(number -> number > 3)
                .mapToInt(number -> (int) number)
                .sum();

        assertThat(result).isEqualTo(15);
    }

    @Test
    public void sumAllDouble() {
        final int result = numbers.stream()
                .mapToInt(number -> (int) number * 2)
                .sum();

        assertThat(result).isEqualTo(42);
    }

    @Test
    public void sumAllTreeAndDouble() {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (number > 3) {
                sum = sum + (number * 2);
            }
        }

        final int result = numbers.stream()
                .filter(number -> number > 3)
                .mapToInt(number -> number * 2)
                .sum();

        final int result2 = numbers.stream()
                .filter(number -> number > 3)
                .map(number -> number * 2)
                .reduce(0, (number1, number2) -> number1 + number2);

        assertThat(sum).isEqualTo(30);
        assertThat(result).isEqualTo(30);
        assertThat(result2).isEqualTo(30);
    }

    @Test
    public void name() {
        final List<Integer> result = numbers.stream()
                .map(number -> number * 2)
                .collect(Collectors.toList());

        final List<String> names = Arrays.asList("a", "b", "c");
        final List<Car> cars = names.stream()
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());

    }
}
