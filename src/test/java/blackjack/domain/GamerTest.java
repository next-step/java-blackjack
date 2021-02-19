package blackjack.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GamerTest {
    @Test
    void getMoreCardTest() {
        Deck deck = new Deck(false);
        Gamer gamer = new Gamer("seokkie", deck);

        gamer.getMoreCard("y", deck);
        Assertions.assertThat(gamer.getCards().getCardList()).hasSize(3);

        gamer.getMoreCard("n", deck);
        Assertions.assertThat(gamer.getCards().getCardList()).hasSize(3);
    }
}
