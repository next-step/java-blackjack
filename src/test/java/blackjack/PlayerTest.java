package blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

    @DisplayName("게임 시작시 이름들을 입력하면 유저들이 생성 된다.")
    @Test
    void playerGenerateTest() {
        assertDoesNotThrow(() -> new Player("현진"));
    }

    @DisplayName("게임 시작시 이름이 없이는 유저를 생성할 수 없다.")
    @Test
    void playerGenerateFailTest() {
        assertThrows(IllegalArgumentException.class, () -> new Player(" "));
    }

    @DisplayName("유저는 이름을 반환할 수 있다.")
    @Test
    void getNameTest() {
        Player player = new Player("재언");

        assertThat(player.getName()).isEqualTo("재언");
    }
}
