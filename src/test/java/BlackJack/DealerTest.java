package BlackJack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DealerTest {
    private List<Player> players;
    private Dealer dealer;
    private PlayGame playGame;
    private CardMachine cardMachine;
    private CardPack cardPack;

    @BeforeEach
    void setUp() {
        players = Arrays.asList(new Player("ss"), new Player("yy"));
        dealer = new Dealer();
        playGame = new PlayGame(players, dealer);
        cardMachine = new CardMachine();
        cardPack = cardMachine.createCards();
    }

    @DisplayName("딜러는 발급받은 두 장의 합을 구할 수 있다.")
    @Test
    void sumCardsTest() {
        int dealerAddedCardsValue = 0;
        playGame.gameStart(2);
        dealerAddedCardsValue = dealer.sumCards();
        assertThat(dealerAddedCardsValue).isBetween(2, 21);
    }

    @DisplayName("ace가 뽑혔을 때 11이 나올 수 있다.")
    @Test
    void findAce11Test() {
        Card get_CardDealerAce = cardPack.getCards().get(0);
        dealer.getCard(get_CardDealerAce);
        Card get_CardDealerTen = cardPack.getCards().get(9);
        dealer.getCard(get_CardDealerTen);
        assertThat(dealer.sumCards()).isEqualTo(21);

    }

    @DisplayName("ace가 뽑혔을 때 1이 나올 수 있다.")
    @Test
    void findAce1Test() {
        Card get_CardDealerAce1 = cardPack.getCards().get(0);
        dealer.getCard(get_CardDealerAce1);
        Card get_CardDealerAce2 = cardPack.getCards().get(13);
        dealer.getCard(get_CardDealerAce2);
        assertThat(dealer.sumCards()).isEqualTo(12);

    }
}