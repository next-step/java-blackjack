package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgementTest {

    @DisplayName("플레이어와 딜러의 결과값을 가지고 승자를 찾는다")
    @Test
    void testFindWinner() {
        Player player1 = new Player("a");
        Player player2 = new Player("b");
        Dealer dealer = new Dealer();
        List<Player> players = Arrays.asList(player1, player2, dealer);
        player1.receiveCard(new Card(Suit.DIAMONDS, Denomination.ACE));
        player1.receiveCard(new Card(Suit.SPADES, Denomination.NINE));  // 20
        player2.receiveCard(new Card(Suit.SPADES, Denomination.FIVE));
        player2.receiveCard(new Card(Suit.CLOVERS, Denomination.SEVEN));
        player2.receiveCard(new Card(Suit.SPADES, Denomination.NINE));   // 21
        dealer.receiveCard(new Card(Suit.SPADES, Denomination.KING));
        dealer.receiveCard(new Card(Suit.SPADES, Denomination.SIX));    // 16

        Judgement judgement = new Judgement(players);
        List<String> winners = judgement.findWinners();
        assertThat(winners).containsExactly("b");
    }
}
