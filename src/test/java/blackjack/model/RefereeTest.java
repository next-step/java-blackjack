package blackjack.model;

import blackjack.model.state.Bust;
import blackjack.model.state.Stay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RefereeTest {
    BunchOfCard bustCards;
    BunchOfCard notBustCards;

    @BeforeEach
    void setUpUser() {
        bustCards = new BunchOfCard();
        notBustCards = new BunchOfCard();

        bustCards.addCard(new Card(CardTypes.CLOVER_2));
        bustCards.addCard(new Card(CardTypes.DIAMOND_J));
        bustCards.addCard(new Card(CardTypes.DIAMOND_K));

        notBustCards.addCard(new Card(CardTypes.CLOVER_2));
        notBustCards.addCard(new Card(CardTypes.DIAMOND_J));

    }

    @DisplayName("딜러가 버스트이고 유저가 버스트가 아니면 유저가 승리한다.")
    @Test
    void userWinningTest() {
        Dealer dealer = new Dealer(new Bust(bustCards));
        User user = new User("J", new Stay(notBustCards));

        Referee.makeWinningState(dealer, user);

        assertAll(
                () -> assertThat(dealer.getLoseCount()).isEqualTo(1),
                () -> assertThat(user.getWinCount()).isEqualTo(1)
        );
    }

    @DisplayName("딜러가 버스트가 아니고 유저가 버스트면 유저가 페베힌다.")
    @Test
    void userLosingTest() {
        Dealer dealer = new Dealer(new Stay(notBustCards));
        User user = new User("J", new Bust(bustCards));

        Referee.makeWinningState(dealer, user);

        assertAll(
                () -> assertThat(dealer.getWinCount()).isEqualTo(1),
                () -> assertThat(user.getLoseCount()).isEqualTo(1)
        );
    }

    @DisplayName("딜러와 유저가 둘 다 버스트이면 유저의 패배이다.")
    @Test
    void userDrawingTest() {
        Dealer dealer = new Dealer(new Bust(bustCards));
        User user = new User("J", new Bust(bustCards));

        Referee.makeWinningState(dealer, user);

        assertAll(
                () -> assertThat(dealer.getWinCount()).isEqualTo(1),
                () -> assertThat(user.getLoseCount()).isEqualTo(1)
        );
    }

    @DisplayName("딜러와 유저가 둘다 버스트가 아니면 카드가 높은쪽이 승리한다.")
    @Test
    void userBiggestTest() {
        Dealer dealer = new Dealer(new Stay(notBustCards));
        notBustCards.addCard(new Card(CardTypes.CLOVER_4));
        User user = new User("J", new Stay(notBustCards));

        Referee.makeWinningState(dealer, user);

        assertAll(
                () -> assertThat(dealer.getLoseCount()).isEqualTo(1),
                () -> assertThat(user.getWinCount()).isEqualTo(1)
        );
    }

    @DisplayName("딜러와 유저가 둘다 버스트가 아니면 카드가 높은쪽이 승리한다.")
    @Test
    void dealerBiggestTest() {
        User user = new User("J", new Stay(notBustCards));
        notBustCards.addCard(new Card(CardTypes.CLOVER_4));
        Dealer dealer = new Dealer(new Stay(notBustCards));

        Referee.makeWinningState(dealer, user);

        assertAll(
                () -> assertThat(dealer.getWinCount()).isEqualTo(1),
                () -> assertThat(user.getLoseCount()).isEqualTo(1)
        );
    }

    @DisplayName("딜러와 유저가 둘다 버스트가 아니고 값이 같으면 무승부다")
    @Test
    void sameValueTest() {
        Dealer dealer = new Dealer(new Stay(notBustCards));
        User user = new User("J", new Stay(notBustCards));

        Referee.makeWinningState(dealer, user);

        assertAll(
                () -> assertThat(dealer.getDrawCount()).isEqualTo(1),
                () -> assertThat(user.getDrawCount()).isEqualTo(1)
        );
    }
}
