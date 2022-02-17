package blackjack;

import blackjack.domain.CardNumber;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CardNumberTest {

    public static Stream<Arguments> makeEnum() {
        return Stream.of(Arguments.of(CardNumber.ACE, true), Arguments.of(CardNumber.KING, false));
    }

    @ParameterizedTest
    @MethodSource("makeEnum")
    public void 카드가_에이스_인지_확인_테스트(CardNumber cardNumber, boolean expect) {
        Assertions.assertEquals(cardNumber.isAce(), expect);
    }

}
