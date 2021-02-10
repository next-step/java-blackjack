package blackjack.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {



    @DisplayName("카드패의 점수 계산 테스트")
    @Test
    void calculateScoreTest () {
        Type diamond = Type.DIAMOND;

        CardBundle cardHand = CardBundle.of(Arrays.asList(
                Card.of(diamond, Symbol.ACE),
                Card.of(diamond, Symbol.JACK)
        ));
        Player player = new Player(cardHand,"test");

        assertThat(player.calculateScore()).isEqualTo(11);

    }
}