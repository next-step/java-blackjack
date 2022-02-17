package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameResultTest {

    Dealer dealer;
    Players players;

    @BeforeEach
    void 테스트_셋업() {
        dealer = new Dealer();
        dealer.ownCards.addCard(new Card(CardNumber.KING, CardType.DIAMOND));
        dealer.ownCards.addCard(new Card(CardNumber.QUEEN, CardType.DIAMOND));

        Player player = new Player("pobi");
        player.ownCards.addCard(new Card(CardNumber.FIVE, CardType.HEART));
        player.ownCards.addCard(new Card(CardNumber.EIGHT, CardType.HEART));

        Player player2 = new Player("pubi");
        player2.ownCards.addCard(new Card(CardNumber.TEN, CardType.HEART));
        player2.ownCards.addCard(new Card(CardNumber.TEN, CardType.CLOBER));
        player2.ownCards.addCard(new Card(CardNumber.ACE, CardType.CLOBER));

        players = new Players(Arrays.asList(player, player2));
    }

    @Test
    void 블랙잭_딜러_결과_테스트() {
        assertThat(GameResult.calGameResult(dealer, players).getDealerGameResult()).isEqualTo(
            Arrays.asList("1승", "1패"));
    }

    @Test
    void 블랙잭_플레이어_결과_테스트() {
        assertThat(GameResult.calGameResult(dealer, players).getplayerGameResult()).isEqualTo(
            Arrays.asList("pobi : 패", "pubi : 승"));
    }
}
