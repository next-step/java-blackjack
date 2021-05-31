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
    void setUP() {
        // numbers int 리스트
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void sumAll() {
        final int result = numbers.stream()
                .mapToInt(number -> number)
                .sum()
        ;
//        // integer 형태의 stream
//        // number는 integer이므로 int로 바꿔줘야함
//        // integer number를 int number로 받는 다는 의미
//        // 그 후에 sum을 함
//        numbers.stream()
//                .mapToInt(number -> number)
//                .sum()
//                ;
        assertThat(result).isEqualTo(21);
    }

    @Test
    public void sumAllEven() {
        // stream
        final int result = numbers.stream()
                // int형으로 값 변경
                .mapToInt(number -> number)
                // 조건문(boolean)
                .filter(number -> number % 2 ==0)
                // 더하기
                .sum()
                ;
        assertThat(result).isEqualTo(12);
    }

    @Test
    public void sumAllOverThree() {
        // stream
        final int result = numbers.stream()
                // 자료형 변경 (int)
                .mapToInt(number -> number)
                // 조건문(boolean)
                .filter(number -> number >3)
                // 더하기
                .sum()
                ;
        assertThat(result).isEqualTo(15);
    }

    @Test
    public void sumAllDouble() {
        // stream
        final int result = numbers.stream()
                // 자료형 변경 (int)
                .mapToInt(number -> number * 2)
                .sum()
                ;
        assertThat(result).isEqualTo(42);
    }

    @Test
    public void name() {
        // stream
        // List integer -> 2배 List integer
        final List<Integer> actual = (List<Integer>) numbers.stream()
                .map(number -> number * 2)
                .collect(Collectors.toList());
        assertThat(actual).contains(2,4,6,8,10,12);

        // List String 을 List Car
        final List<String> names = Arrays.asList("s","t","j");
        final List<Car> car = names.stream()
                .map(name -> new Car(name,0))
                .collect(Collectors.toList())
                ;
    }
}
