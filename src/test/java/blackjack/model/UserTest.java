package blackjack.model;

import blackjack.model.state.Hit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    private User user;
    BunchOfCard bunchOfCard;

    @BeforeEach
    void setUpUser() {
        bunchOfCard = new BunchOfCard();

        bunchOfCard.addCard(new Card(CardTypes.CLOVER_2));
        bunchOfCard.addCard(new Card(CardTypes.DIAMOND_J));

        user = new User("재언", new Hit(bunchOfCard));
    }

    @DisplayName("이름을 입력하면 유저가 생성 된다.")
    @Test
    void userGenerateTest() {
        assertDoesNotThrow(() -> new User("재언", new Hit(bunchOfCard)));
    }

    @DisplayName("이름 없이는 유저를 생성할 수 없다.")
    @Test
    void userGenerateFailTest() {
        assertThrows(IllegalArgumentException.class, () -> new User("", new Hit(bunchOfCard)));
    }

    @DisplayName("유저는 이름을 반환할 수 있다.")
    @Test
    void getNameTest() {
        assertThat(user.getName()).isEqualTo("재언");
    }

    @DisplayName("유저는 카드의 이름들을 반환 할 수있다.")
    @Test
    void getNamesTest() {
        assertThat(user.getCardNames()).contains("2클로버", "J다이아몬드");
    }

    @DisplayName("유저는 카드들의 값의 합을 반환 할 수있다.")
    @Test
    void getUserCardValueSumTest() {
        assertThat(user.getCardValueSum()).isEqualTo(12);
    }

    @DisplayName("여러 장의 카드를 입력하면 동일한 이름의 개수를 반환 할 수있다.")
    @Test
    void addSeveralCardTest() {
        assertThat(user.getCardNames().size()).isEqualTo(2);
    }
}
