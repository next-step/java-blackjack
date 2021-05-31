package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Test1 {
    private List<Integer> numbers;

    @BeforeEach
    void setUP() {
        // numbers int 리스트
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("mapToInt")
    void map(){
        final int result = numbers.stream()
        .filter(number -> number >3)
        .mapToInt(number -> number * 2)
        .sum()
        ;
        assertThat(result).isEqualTo(30);
    }

    @Test
    @DisplayName("Reduce")
    void test2(){
        final int result = numbers.stream()
                .filter(number -> number >3)
                .map(number -> number * 2)
                // reduce(초기값, (변수) -> 식)
                .reduce(0, (number1, number2) -> (number1 + number2))
                ;
        assertThat(result).isEqualTo(30);
    }

    @Test
    @DisplayName("for 구문")
    void test3(){
        int result = 0;
        for (int number : numbers) {
            if(number >3){
                result += number * 2;
            }
        }
        assertThat(result).isEqualTo(30);
    }
}


