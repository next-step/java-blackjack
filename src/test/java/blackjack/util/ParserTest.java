package blackjack.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    @DisplayName("플레이어의 이름을 정상적으로 반환한다.")
    @Test
    void Given유효한값_When파싱_Then이름_반환() {
        final List<String> names = Parser.parse(" json, pobi ");
        assertThat(names).isEqualTo(Arrays.asList("json","pobi"));
    }

    @DisplayName("플레이어의 이름이 하나라도 빈 값이면 예외를 발생시칸다.")
    @ValueSource(strings = {"kim, ,jun", "", ",", " , ", "kim,", ",kim", ",,kim", "kim,,", "kim, ,"})
    @ParameterizedTest
    void Given빈_값_When파싱_Then예외_발생(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Parser.parse(input));
    }
}