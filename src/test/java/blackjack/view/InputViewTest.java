package blackjack.view;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.Player;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName(",로 구분된 이름들의 문자열을 리스트 형태로 반환한다")
    @Test
    void getPlayersName() {
        InputStream inputStream = new ByteArrayInputStream("pobi,jason".getBytes());
        System.setIn(inputStream);
        List<String> players = InputView.getPlayersName();

        assertThat(players).containsExactly("pobi", "jason");
    }

    @DisplayName("y를 입력하면 true를 반환한다.")
    @Test
    void testAskAddCard() {
        InputStream inputStream = new ByteArrayInputStream("y".getBytes());
        System.setIn(inputStream);

        boolean yesOrNo = InputView.askAddCard(new Player("pobi"));
        assertThat(yesOrNo).isTrue();
    }

}