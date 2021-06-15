package blackjack.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

    @DisplayName("이름을 입력하면 유저가 생성 된다.")
    @Test
    void userGenerateTest() {
        assertDoesNotThrow(() -> PlayerFactory.of("현진"));
    }

    @DisplayName("이름 없이는 유저를 생성할 수 없다.")
    @Test
    void userGenerateFailTest() {
        assertThrows(IllegalArgumentException.class, () -> PlayerFactory.of(" "));
    }

    @DisplayName("유저는 이름을 반환할 수 있다.")
    @Test
    void getNameTest() {
        Player user = PlayerFactory.of("재언");

        assertThat(user.getName()).isEqualTo("재언");
    }

    @DisplayName("유저는 카드의 이름들을 반환 할 수있다.")
    @Test
    void getNamesTest() {
        Player user = PlayerFactory.of("재언");

        user.addCard(new Card(CardTypes.CLOVER_2));
        user.addCard(new Card(CardTypes.DIAMOND_J));

        assertThat(user.getCardNames()).contains("2클로버", "J다이아몬드");
    }

    @DisplayName("유저는 카드들의 값의 합을 반환 할 수있다.")
    @Test
    void getUserCardValueSumTest() {
        Player user = PlayerFactory.of("재언");

        user.addCard(new Card(CardTypes.CLOVER_2));
        user.addCard(new Card(CardTypes.DIAMOND_J));

        assertThat(user.getCardValueSum()).isEqualTo(12);
    }

    @DisplayName("여러 장의 카드를 입력하면 동일한 이름의 개수를 반환 할 수있다.")
    @Test
    void addSeveralCardTest() {
        Player user = PlayerFactory.of("재언");
        CardGenerator cardGenerator = new CardGenerator();
        user.addSeveralCard(cardGenerator.getSeveralCard(3));

        assertThat(user.getCardNames().size()).isEqualTo(3);
    }

    @DisplayName("딜러는 카드의 이름들을 반환 할 수있다.")
    @Test
    void getCardNamesTest() {
        Player dealer = PlayerFactory.of("딜러");

        dealer.addCard(new Card(CardTypes.CLOVER_2));
        dealer.addCard(new Card(CardTypes.DIAMOND_J));

        assertThat(dealer.getCardNames()).contains("2클로버", "J다이아몬드");
    }

    @DisplayName("딜러는 카드들의 값의 합을 반환 할 수있다.")
    @Test
    void getDealerCardValueSumTest() {
        Player dealer = PlayerFactory.of("딜러");

        dealer.addCard(new Card(CardTypes.CLOVER_2));
        dealer.addCard(new Card(CardTypes.DIAMOND_J));

        assertThat(dealer.getCardValueSum()).isEqualTo(12);
    }
}
