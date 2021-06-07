package blackjack.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    Player player;
    CardDeck cardDeck = new CardDeck();

    @BeforeEach
    void set() {
        player = new Gamer("1");

    }

    @DisplayName("뽑기")
    @Test
    void 뽑기() {
        player.draw(cardDeck);
        assertThat(player.getCards().size()).isEqualTo(1);
    }

    @DisplayName("뽑기 시작")
    @Test
    void 뽑기_시작() {
        player.startDraw(cardDeck);
        assertThat(player.getCards().size()).isEqualTo(2);
    }

    @DisplayName("점수구하기")
    @Test
    void sumScore() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardPattern.CLUBS, CardNumber.ACE));
        cards.add(new Card(CardPattern.CLUBS, CardNumber.EIGHT));
        cards.add(new Card(CardPattern.CLUBS, CardNumber.FIVE));
        player.setCards(cards);
        assertThat(player.sumScore()).isEqualTo(14);

    }
}
