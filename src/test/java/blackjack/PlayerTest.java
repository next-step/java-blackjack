package blackjack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import blackjack.domain.Card;
import blackjack.domain.CardNumber;
import blackjack.domain.Cards;
import blackjack.domain.Dealer;
import blackjack.domain.Player;
import blackjack.domain.Score;
import blackjack.domain.Suit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PlayerTest {

    private Player player;

    static Stream<Arguments> scoreCases() {
        return Stream.of(
            Arguments.of(Arrays.asList(new Card(CardNumber.FIVE, Suit.HEART)),
                Arrays.asList(new Card(CardNumber.TWO, Suit.HEART)), Score.WIN),
            Arguments.of(Arrays.asList(new Card(CardNumber.TWO, Suit.HEART)),
                Arrays.asList(new Card(CardNumber.TWO, Suit.HEART)), Score.DRAW),
            Arguments.of(Arrays.asList(new Card(CardNumber.TWO, Suit.HEART)),
                Arrays.asList(new Card(CardNumber.FIVE, Suit.HEART)), Score.LOSE)
        );
    }

    @BeforeEach
    void init() {
        player = new Player("a", new Cards(Arrays.asList(new Card(CardNumber.EIGHT, Suit.CLUB),
            new Card(CardNumber.FIVE, Suit.DIAMOND))));
    }

    @Test
    void 카드점수_확인_테스트() {
        assertThat(player.getTotalScore()).isEqualTo(13);
    }

    @ParameterizedTest
    @MethodSource("scoreCases")
    void 딜러_플레이어의_점수_비교_테스트(List<Card> playerCards, List<Card> dealerCards, Score result) {
        Player player = new Player("플레이어", new Cards(playerCards));
        Dealer dealer = new Dealer("딜러", new Cards(dealerCards));

        assertEquals(player.compareScore(dealer), result);
    }
}
