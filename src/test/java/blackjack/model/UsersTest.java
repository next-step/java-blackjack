package blackjack.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class UsersTest {

    @DisplayName("이름들을 입력하면 유저들이 생성 된다.")
    @Test
    void usersGenerateTest() {
        List<String> userNames = Arrays.asList("pobi", "jason");

        assertDoesNotThrow(() -> PlayerGenerator.makeUsers(userNames));
    }

    @DisplayName("Users 생성시 유저 개수를 반환 할 수있다.")
    @Test
    void usersSizeTest() {
        List<String> userNames = Arrays.asList("pobi", "jason");
        Users users = PlayerGenerator.makeUsers(userNames);

        Assertions.assertThat(users.getUsers().size()).isEqualTo(2);
    }
}
