package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgementTest {

    static List<Player> players;
    static Judgement judgement;

    @BeforeAll
    static void setUp() {
        Player player1 = new Player("a");
        Player player2 = new Player("b");
        Dealer dealer = new Dealer();
        players = Arrays.asList(player1, player2, dealer);
        player1.receiveCard(new Card(Suit.DIAMONDS, Denomination.ACE));
        player1.receiveCard(new Card(Suit.SPADES, Denomination.NINE));  // 20
        player2.receiveCard(new Card(Suit.SPADES, Denomination.FIVE));
        player2.receiveCard(new Card(Suit.CLOVERS, Denomination.SEVEN));
        player2.receiveCard(new Card(Suit.SPADES, Denomination.NINE));   // 21
        dealer.receiveCard(new Card(Suit.SPADES, Denomination.KING));
        dealer.receiveCard(new Card(Suit.SPADES, Denomination.SIX));    // 16
        judgement = new Judgement(players);
    }

    @DisplayName("플레이어와 딜러의 결과값을 가지고 승패를 찾는다")
    @Test
    void testFindWinner() {
        Map<String, String> playerResults = judgement.findWinners();
        assertThat(playerResults.get("a")).isEqualTo("승");
        assertThat(playerResults.get("b")).isEqualTo("승");
        assertThat(playerResults.get("딜러")).isEqualTo("0승 2패");
    }
}
