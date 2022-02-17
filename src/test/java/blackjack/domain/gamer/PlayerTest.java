package blackjack.domain.gamer;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Suit;
import blackjack.domain.matchInfo.MatchResult;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void 플레이어가_딜러랑_카드합이_같으면_무승부다() {
        Player player = new Player("yang", Arrays.asList(new Card(Denomination.ACE, Suit.DIAMONDS),
            new Card(Denomination.TEN, Suit.DIAMONDS)));
        Dealer dealer = new Dealer(Arrays.asList(new Card(Denomination.ACE, Suit.DIAMONDS),
            new Card(Denomination.TEN, Suit.DIAMONDS)));
        MatchResult matchResult = player.getMatchResult(player, dealer);
        assertThat(matchResult.getName()).isEqualTo("무");
    }

    @Test
    void 플레이어가_딜러보다_카드합이_크면_승리한다() {
        Player player = new Player("yang", Arrays.asList(new Card(Denomination.ACE, Suit.DIAMONDS),
            new Card(Denomination.TEN, Suit.DIAMONDS)));
        Dealer dealer = new Dealer(Arrays.asList(new Card(Denomination.ACE, Suit.DIAMONDS),
            new Card(Denomination.FIVE, Suit.DIAMONDS)));
        MatchResult matchResult = player.getMatchResult(player, dealer);
        assertThat(matchResult.getName()).isEqualTo("승");
    }

    @Test
    void 플레이어가_딜러보다_카드합이_작으면_패배한다() {
        Player player = new Player("yang", Arrays.asList(new Card(Denomination.ACE, Suit.DIAMONDS),
            new Card(Denomination.TWO, Suit.DIAMONDS)));
        Dealer dealer = new Dealer(Arrays.asList(new Card(Denomination.ACE, Suit.DIAMONDS),
            new Card(Denomination.FIVE, Suit.DIAMONDS)));
        MatchResult matchResult = player.getMatchResult(player, dealer);
        assertThat(matchResult.getName()).isEqualTo("패");
    }
}
