package blackjack.domain.user;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Number;
import blackjack.domain.card.Suit;
import blackjack.domain.report.GameReport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DealerTest {

    static Dealer dealer;

    @BeforeAll
    static void setUp() {
        dealer = new Dealer();
        dealer.drawCard(new Card(Suit.CLOVER, Number.FIVE));
        dealer.drawCard(new Card(Suit.CLOVER, Number.SIX));
    }

    @Test
    void 딜러인지_확인할_수_있다() {
        assertThat(dealer.isDealer()).isTrue();
        assertThat(dealer.isPlayer()).isFalse();
    }

    @Test
    void 딜러가_가진_패의_합을_확인_할_수_있다() {
        assertThat(dealer.score()).isEqualTo(11);
    }

    @Test
    void 딜러가_가진_패의_합이_16이하라면_패를_뽑아야_한다() {
        assertThat(dealer.isDrawable()).isTrue();
    }

    @Test
    void 딜러는_자신보다_낮은_패를_가진_플레이어와_비교해_패배_리포트를_생성할_수_있다() {
        Player player = new Player("loser");
        player.drawCard(new Card(Suit.DIAMOND, Number.FOUR));
        player.drawCard(new Card(Suit.DIAMOND, Number.TWO));
        GameReport gameReport = dealer.createReport(player);
        assertThat(gameReport.isLose()).isTrue();
    }

    @Test
    void 딜러는_자신보다_높은_패를_가진_플레이어와_비교해_승리_리포트를_생성할_수_있다() {
        Player player = new Player("winner");
        player.drawCard(new Card(Suit.DIAMOND, Number.FOUR));
        player.drawCard(new Card(Suit.DIAMOND, Number.EIGHT));
        GameReport gameReport = dealer.createReport(player);
        assertThat(gameReport.isWin()).isTrue();
    }

    @Test
    void 딜러는_자신과_같은_패를_가진_플레이어와_비교해_무승부_리포트를_생성할_수_있다() {
        Player player = new Player("drawer");
        player.drawCard(new Card(Suit.DIAMOND, Number.SIX));
        player.drawCard(new Card(Suit.DIAMOND, Number.FIVE));
        GameReport gameReport = dealer.createReport(player);
        assertThat(gameReport.isDraw()).isTrue();
    }
}
