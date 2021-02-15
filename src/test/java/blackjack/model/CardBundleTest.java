package blackjack.model;

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


}
