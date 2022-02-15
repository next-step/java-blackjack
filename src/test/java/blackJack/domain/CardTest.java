package blackJack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CardTest {

    static Stream<Arguments> generateCardTypeAndCardNumber() {
        return Stream.of(
            Arguments.of(Arrays.asList("다이아몬드", "2")),
            Arguments.of(Arrays.asList("하트", "3")),
            Arguments.of(Arrays.asList("클로버", "4")),
            Arguments.of(Arrays.asList("스페이드", "5")),
            Arguments.of(Arrays.asList("다이아몬드", "6")),
            Arguments.of(Arrays.asList("클로버", "J"))
        );
    }

    @DisplayName("카드 숫자와 카드 타입을 입력할때, 주어진 숫자와 타입으로 카드가 생성된다.")
    @ParameterizedTest
    @MethodSource("generateCardTypeAndCardNumber")
    void givenNumberWithStringAndTypeWithString_WhenGetCardNumberAndGetCardType_ThenEqualToGivenNumberAndType(
        List<String> cardParameter) {
        Card card = Card.of(cardParameter.get(0), cardParameter.get(1));

        assertThat(
            Arrays.asList(card.getCardType().getCardType(), card.getCardNumber().getCardNumber()))
            .isEqualTo(cardParameter);
    }
}