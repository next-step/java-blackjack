package blackjack.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {


    @DisplayName("User 생성 테스트")
    @Test
    void init() {
        int expectedMoney = 10000;
        String expectedName = "TEST";
        CardBundle cardBundle = CardBundle.of(Arrays.asList(
                Fixtures.HEART_ACE_CARD,
                Fixtures.HEART_TWO_CARD
                ));
        User user = User.of(cardBundle, expectedName, expectedMoney);
        assertThat(user.getMoney()).isEqualTo(expectedMoney);
        assertThat(user.getName()).isEqualTo(expectedName);
    }
}