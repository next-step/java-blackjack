package blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    void 이름을_가진다(){
        final Player player = new Player("pobi");
        String actual = player.getName();
        assertThat(actual).isEqualTo("pobi");
    }

    @Test
    void 카드를_1장_받는다(){
        final Player player = new Player("pobi");
        final Deck deck = new Deck();
        final Card card = deck.getOneCard(0);
        player.add(card);
        Integer actual = player.getSum();
        assertThat(actual).isEqualTo(card.toInt());
    }

    @Test
    void 카드_합을_계산한다(){
        final Player player = new Player("pobi");
        final Deck deck = new Deck();
        final Card card0 = deck.getOneCard(0);
        final Card card1 = deck.getOneCard(1);
        player.add(card0);
        player.add(card1);
        Integer actual = player.getSum();
        assertThat(actual).isEqualTo(card0.toInt() + card1.toInt());
    }
}
