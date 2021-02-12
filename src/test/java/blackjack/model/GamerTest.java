package blackjack.model;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GamerTest {
    @Test
    @DisplayName("게이머가 카드를 받았을 때, 한장의 카드의 이름을 출력하는 테스트")
    void receiveOneCardStatsTest() {
        final ShuffleStrategy emptyShuffleStrategy = new EmptyShuffleStrategy();
        final Deck deck = new Deck(emptyShuffleStrategy);
        final Gamer gamer = new Gamer("Jason", deck);
        gamer.receiveCard();
        final Pocket pocket = gamer.getCardStats();
        final String cardsName = pocket.getCardsName();

        AssertionsForClassTypes.assertThat(cardsName).isEqualTo("K클로버");
    }

    @Test
    @DisplayName("게이머가 카드를 받았을 때, 두 장의 카드의 이름을 출력하는 테스트")
    void receiveTwoCardStatsTest() {
        final ShuffleStrategy emptyShuffleStrategy = new EmptyShuffleStrategy();
        final Deck deck = new Deck(emptyShuffleStrategy);
        final Gamer gamer = new Gamer("Jason", deck);
        gamer.receiveCard();
        gamer.receiveCard();
        final Pocket pocket = gamer.getCardStats();
        final String cardsName = pocket.getCardsName();

        AssertionsForClassTypes.assertThat(cardsName).isEqualTo("K클로버, K스페이드");
    }

    @Test
    @DisplayName("게이머가 한 장의 카드를 뽑았을때 소유한 카드를 테스트")
    void exportCardStatsTest() {
        final ShuffleStrategy emptyShuffleStrategy = new EmptyShuffleStrategy();
        final Deck deck = new Deck(emptyShuffleStrategy);
        final Gamer gamer = new Gamer("Jason", deck);
        gamer.receiveCard();

        final String exportCardStats = gamer.exportCardStats();
        AssertionsForClassTypes.assertThat(exportCardStats).isEqualTo("Jason : K클로버");
    }

    @Test
    @DisplayName("갖고 있는 Job이 정상적으로 나오는 지, 출력하는 테스트")
    void getJobTest() {
        final ShuffleStrategy emptyShuffleStrategy = new EmptyShuffleStrategy();
        final Deck deck = new Deck(emptyShuffleStrategy);
        final Gamer gamer = new Gamer("Jason", deck);

        assertThat(gamer.getJob()).isEqualTo(Job.GAMER);
    }

    @Test
    @DisplayName("가지고 있는 카드의 총합이 정상적으로 계산되는 지, 확인하는 테스트")
    void getCardsScoreTest() {
        final ShuffleStrategy emptyShuffleStrategy = new EmptyShuffleStrategy();
        final Deck deck = new Deck(emptyShuffleStrategy);
        final Gamer gamer = new Gamer("Jason", deck);
        gamer.receiveCard();
        gamer.receiveCard();

        final int cardsScore = gamer.getCardsScore();
        assertThat(cardsScore).isEqualTo(20);
    }

    @Test
    @DisplayName("ACE카드를 가지고있는지 확인하는 테스트")
    void hasAceTest() {
        final ShuffleStrategy emptyShuffleStrategy = new EmptyShuffleStrategy();
        final Deck deck = new Deck(emptyShuffleStrategy);
        final Gamer gamer = new Gamer("Jason", deck);

        gamer.receiveCard();
        gamer.receiveCard();

        final boolean hasAce = gamer.hasAce();
        assertThat(hasAce).isEqualTo(false);
    }
}