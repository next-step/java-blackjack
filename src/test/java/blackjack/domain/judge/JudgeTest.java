package blackjack.domain.judge;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Hands;
import blackjack.domain.card.Pattern;
import blackjack.domain.card.Rank;
import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Player;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgeTest {

    private final Hands score16 = new Hands(Arrays.asList(
        new Card(Pattern.CLUB, Rank.TEN),
        new Card(Pattern.HEART, Rank.SIX)));

    private final Hands score21 = new Hands(Arrays.asList(
        new Card(Pattern.DIAMOND, Rank.ACE),
        new Card(Pattern.HEART, Rank.TEN)));

    private final Hands score26 = new Hands(Arrays.asList(
        new Card(Pattern.DIAMOND, Rank.TEN),
        new Card(Pattern.HEART, Rank.SIX),
        new Card(Pattern.HEART, Rank.TEN)));

    private final Judge judge = new Judge();

    private final Map<String, String> playerWin = new HashMap() {
        {
            put("딜러", "0승 1패");
            put("jason", "승");
        }
    };

    private final Map<String, String> dealerWin = new HashMap() {
        {
            put("딜러", "1승 0패");
            put("jason", "패");
        }
    };

    @DisplayName("플레이어가 딜러보다 점수가 높으면 플레이어가 승리한다.")
    @Test
    void Given플레이어_딜러_점수_When플레이어가_높은_Then플레이어_승리() {
        final Dealer dealer = new Dealer(score16);
        final Player player = new Player("jason", score21);

        assertThat(judge.getWinOrLose(dealer, Arrays.asList(player))).isEqualTo(playerWin);
    }

    @DisplayName("플레이어가 딜러보다 점수가 낮으면 딜러가 승리한다.")
    @Test
    void Given플레이어_딜러_점수_When딜러가_높은_The딜러_승리() {
        final Dealer dealer = new Dealer(score21);
        final Player player = new Player("jason", score16);

        assertThat(judge.getWinOrLose(dealer, Arrays.asList(player))).isEqualTo(dealerWin);
    }

    @DisplayName("딜러와 플레이어가 모두 21을 넘었을 때, 딜러가 승리한다.")
    @Test
    void Given플레이어_딜러_점수_When둘다_21_초과_The딜러_승리() {
        final Dealer dealer = new Dealer(score26);
        final Player player = new Player("jason", score26);

        assertThat(judge.getWinOrLose(dealer, Arrays.asList(player))).isEqualTo(dealerWin);
    }

    @DisplayName("딜러는 21을 넘고, 플레이어는 넘지 않았으면 플레이어가 승리한다.")
    @Test
    void Given플레이어_딜러_점수When딜러_21_초과_The플레이어_승리() {
        final Dealer dealer = new Dealer(score26);
        final Player player = new Player("jason", score16);

        assertThat(judge.getWinOrLose(dealer, Arrays.asList(player))).isEqualTo(playerWin);
    }

    @DisplayName("플레이어는 21을 넘고, 딜러는 넘지 않았으면 딜러가 승리한다.")
    @Test
    void Given플레이어_딜러_점수When플레이어_21_초과_The딜러_승리() {
        final Dealer dealer = new Dealer(score21);
        final Player player = new Player("jason", score26);

        assertThat(judge.getWinOrLose(dealer, Arrays.asList(player))).isEqualTo(dealerWin);
    }

    @DisplayName("플레이어와 딜러의 점수가 같으면 딜러가 승리한다.")
    @Test
    void Given플레이어_딜러_점수When같다_The딜러_승리() {
        final Dealer dealer = new Dealer(score21);
        final Player player = new Player("jason", score21);

        assertThat(judge.getWinOrLose(dealer, Arrays.asList(player))).isEqualTo(dealerWin);
    }
}
