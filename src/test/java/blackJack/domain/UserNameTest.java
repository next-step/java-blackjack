package blackJack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserNameTest {

    @DisplayName("String 이름이 주어질때, getUserName 메소드의 값은 주어진 이름과 동일하다.")
    @ParameterizedTest
    @ValueSource(strings = {"이호찬", "박찬우", "holee", "12345"})
    void givenNameWithString_WhenGetUserName_ThenEqualToGivenName(String name) {
        UserName userName = UserName.from(name);

        assertThat(userName.getName())
            .isEqualTo(name);
    }
}