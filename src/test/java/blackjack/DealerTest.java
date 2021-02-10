package blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DealerTest {
    @Test
    @DisplayName("딜러가 카드를 받았을 때, 한장의 카드의 이름을 출력하는 테스트")
    void receiveOneCardStatsTest() {
        final ShuffleStrategy emptyShuffleStrategy = new EmptyShuffleStrategy();
        final Deck deck = new Deck(emptyShuffleStrategy);
        final Dealer dealer = new Dealer("Dealer", deck);
        dealer.receiveCard();
        final Pocket pocket = dealer.getCardStats();
        final String cardsName = pocket.getCardsName();

        assertThat(cardsName).isEqualTo("K클로버");
    }

    @Test
    @DisplayName("딜러가 카드를 받았을 때, 두 장의 카드의 이름을 출력하는 테스트")
    void receiveTwoCardStatsTest() {
        final ShuffleStrategy emptyShuffleStrategy = new EmptyShuffleStrategy();
        final Deck deck = new Deck(emptyShuffleStrategy);
        final Dealer dealer = new Dealer("Dealer", deck);
        dealer.receiveCard();
        dealer.receiveCard();
        final Pocket pocket = dealer.getCardStats();
        final String cardsName = pocket.getCardsName();

        assertThat(cardsName).isEqualTo("K클로버, K스페이드");
    }

    @Test
    @DisplayName("딜러가 한 장의 카드를 뽑았을때 소유한 카드를 테스트")
    void exportCardStatsTest() {
        final ShuffleStrategy emptyShuffleStrategy = new EmptyShuffleStrategy();
        final Deck deck = new Deck(emptyShuffleStrategy);
        final Dealer dealer = new Dealer("Dealer", deck);
        dealer.receiveCard();

        final String exportCardStats = dealer.exportCardStats();
        assertThat(exportCardStats).isEqualTo("Dealer : K클로버");
    }
}