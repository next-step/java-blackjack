package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class ResultValueTest {

    @Test
    void 블랙잭_결과_테스트() {
        Dealer dealer = new Dealer();
        dealer.ownCards.addCard(new Card(CardNumber.KING, CardType.DIAMOND));
        dealer.ownCards.addCard(new Card(CardNumber.QUEEN, CardType.DIAMOND));

        Player player = new Player("pobi");
        player.ownCards.addCard(new Card(CardNumber.FIVE, CardType.HEART));
        player.ownCards.addCard(new Card(CardNumber.EIGHT, CardType.HEART));

        Players players = new Players(Arrays.asList(player));

        assertThat(GameResult.calGameResult(dealer, players).getDealerGameResult()).isEqualTo(
            Collections.singletonList("1승"));
    }
}
