package blackjack.model;

import blackjack.model.card.Card;
import blackjack.model.card.CardBundle;
import blackjack.model.card.Symbol;
import blackjack.model.card.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CardBundleTest {
    private final Type diamond = Type.DIAMOND;
    private CardBundle cardBundle;

    @BeforeEach
    public void beforeEach() {
        cardBundle = CardBundle.of(
                new ArrayList<>(Arrays.asList(
                        Card.of(diamond, Symbol.ACE),
                        Card.of(diamond, Symbol.JACK))
                )
        );
    }

    @DisplayName("cardBundle 의 객체생성 테스트")
    @Test
    public void ofTest() {
        assertThat(cardBundle.getCards().get(0)).isEqualTo(Card.of(diamond, Symbol.ACE));
    }


    @DisplayName("cardBundle score 계산 테스트")
    @Test
    public void calculateScoreTest() {
        int score = cardBundle.calculateScore();
        assertThat(score).isEqualTo(21);

        cardBundle.add(Card.of(diamond, Symbol.JACK));
        score = cardBundle.calculateScore();
        assertThat(score).isEqualTo(21);

        cardBundle.add(Card.of(diamond, Symbol.ACE));
        score = cardBundle.calculateScore();
        assertThat(score).isEqualTo(22);
    }

    @DisplayName("black jack calculate with one ace 테스트")
    @Test
    public void calculateScoreTest2() {
        cardBundle.add(Card.of(diamond, Symbol.ACE));
        int score = cardBundle.calculateScore();
        assertThat(score).isEqualTo(12);
    }

    @DisplayName("black jack calculate 3장 이상 테스트")
    @Test
    public void calculateScoreTest3() {
        CardBundle cardBundle1 = CardBundle.of(
                new ArrayList<>(Arrays.asList(
                        Card.of(diamond, Symbol.ACE),
                        Card.of(diamond, Symbol.ACE),
                        Card.of(diamond, Symbol.EIGHT))
                )
        );
        int score = cardBundle1.calculateScore();
        assertThat(score).isEqualTo(20);
    }

}
