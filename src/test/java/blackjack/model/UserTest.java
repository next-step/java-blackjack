package blackjack.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("User 생성 테스트")
    @Test
    void init() {
        Money expectedMoney = Money.of(10000);
        String expectedName = "TEST";

        User user = User.of(expectedName, expectedMoney);
        assertThat(user.getMoney()).isEqualTo(expectedMoney);
        assertThat(user.getName()).isEqualTo(expectedName);
    }
}