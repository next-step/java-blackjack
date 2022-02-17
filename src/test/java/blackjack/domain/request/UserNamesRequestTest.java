package blackjack.domain.request;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class UserNamesRequestTest {

    @Test
    void 사용자의_쉼표로_구분한_입력으로_사용자_이름_목록을_만들_수_있다() {
        UserNamesRequest userNamesRequest = UserNamesRequest.from("jason,pobi");
        assertThat(userNamesRequest.userNames()).isEqualTo(Arrays.asList("jason", "pobi"));
    }

    @Test
    void 입력된_이름은_중복될_때_예외가_발생된다() {
        assertThatThrownBy(() -> UserNamesRequest.from("jason,pobi,jason"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈_값이_입력되면_예외가_발생한다() {
        assertAll(
            () -> assertThatThrownBy(() -> UserNamesRequest.from("  "))
                .isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> UserNamesRequest.from(null))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
}