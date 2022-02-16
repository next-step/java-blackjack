package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("보유하고 있는 카드의 점수를 모두 계산한다")
    @Test
    void testCalculateScore() {
        Player player = new Player("A");
        player.receiveCard(new Card(Suit.CLOVERS, Denomination.EIGHT));
        player.receiveCard(new Card(Suit.DIAMONDS, Denomination.FIVE));
        int score = player.calculateScore();
        assertThat(score).isEqualTo(13);
    }

    @DisplayName("보유하고 있는 카드가 ACE일 경우 21보다 작고, 21에 근접한 결과로 계산한다. 11로 계산할 경우")
    @Test
    void testCalculateScoreWithAceAsEleven() {
        Player player = new Player("A");
        player.receiveCard(new Card(Suit.DIAMONDS, Denomination.ACE));
        player.receiveCard(new Card(Suit.SPADES, Denomination.FIVE));
        player.receiveCard(new Card(Suit.CLOVERS, Denomination.FIVE));
        int score = player.calculateScore();
        assertThat(score).isEqualTo(21);
    }

    @DisplayName("보유하고 있는 카드가 ACE일 경우 21보다 작고, 21에 근접한 결과로 계산한다. 1로 계산할 경우")
    @Test
    void testCalculateScoreWithAceAsOne() {
        Player player = new Player("A");
        player.receiveCard(new Card(Suit.DIAMONDS, Denomination.ACE));
        player.receiveCard(new Card(Suit.SPADES, Denomination.NINE));
        player.receiveCard(new Card(Suit.CLOVERS, Denomination.NINE));
        int score = player.calculateScore();
        assertThat(score).isEqualTo(19);
    }


}