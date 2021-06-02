package blackjack.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @DisplayName("게임 시작시 이름들을 입력하면 유저들이 생성 된다.")
    @Test
    void playerGenerateTest() {
        assertDoesNotThrow(() -> new User("현진"));
    }

    @DisplayName("게임 시작시 이름이 없이는 유저를 생성할 수 없다.")
    @Test
    void playerGenerateFailTest() {
        assertThrows(IllegalArgumentException.class, () -> new User(" "));
    }

    @DisplayName("유저는 이름을 반환할 수 있다.")
    @Test
    void getNameTest() {
        User user = new User("재언");

        assertThat(user.getName()).isEqualTo("재언");
    }

    @DisplayName("유저는 카드의 이름들을 반환 할 수있다.")
    @Test
    void getNamesTest() {
        User user = new User("재언");

        user.addCard(new Card(CardTypes.CLOVER_2));
        user.addCard(new Card(CardTypes.DIAMOND_J));

        assertThat(user.getCardNames()).contains("2클로버", "J다이아몬드");
    }

    @DisplayName("유저는 카드들의 값의 합을 반환 할 수있다.")
    @Test
    void getCardValueSumTest() {
        User user = new User("재언");

        user.addCard(new Card(CardTypes.CLOVER_2));
        user.addCard(new Card(CardTypes.DIAMOND_J));

        assertThat(user.getCardValueSum()).isEqualTo(12);
    }

    @DisplayName("여러 장의 카드를 입력하면 동일한 이름의 개수를 반환 할 수있다.")
    @Test
    void addSeveralCardTest() {
        User user = new User("재언");
        CardGenerator cardGenerator = new CardGenerator();
        user.addSeveralCard(cardGenerator.getSeveralCard(3));

        assertThat(user.getCardNames().size()).isEqualTo(3);
    }
}
