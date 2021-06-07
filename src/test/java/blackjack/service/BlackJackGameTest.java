package blackjack.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BlackJackGameTest {
    BlackJackGame blackJackGame = new BlackJackGame();
    List<Player> players;

    @BeforeEach
    void set() {
        players = blackJackGame.getPlayer("1,2");
    }

    @Test
    void getPlayer() {
        assertThat(players).usingElementComparatorOnFields("name").containsExactly(new Dealer(), new Gamer("1"), new Gamer("2"));
    }

    @DisplayName("뽑기 시작")
    @Test
    void 뽑기_시작() {
        blackJackGame.startDraw();
        assertThat(players.get(0).getCards().size()).isEqualTo(2);
    }

    @DisplayName("점수가 21이 넘으면 0으로 만들기 테스트")
    @Test
    void setZeroTest() {
        players.get(0).setScore(22);
        blackJackGame.setZero();
        assertThat(players.get(0).getScore()).isEqualTo(0);

    }

    @DisplayName("Ace 존재 여부 테스트")
    @Test
    void aceCheck() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardPattern.CLUBS, CardNumber.ACE));
        cards.add(new Card(CardPattern.CLUBS, CardNumber.EIGHT));
        players.get(1).setCards(cards);
        blackJackGame.aceCheck();
        assertThat(players.get(1).getScore()).isEqualTo(19);
    }

    @DisplayName("Ace 존재 여부 테스트2")
    @Test
    void aceCheck2() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardPattern.CLUBS, CardNumber.ACE));
        cards.add(new Card(CardPattern.CLUBS, CardNumber.EIGHT));
        cards.add(new Card(CardPattern.CLUBS, CardNumber.NINE));
        players.get(1).setCards(cards);
        blackJackGame.aceCheck();
        assertThat(players.get(1).getScore()).isEqualTo(18);
    }

}
