package blackjack.domain.request;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DrawRequestTest {

    @Test
    void 입력받은_요청으로_올바르게_생성자를_생성할_수_있다() {
        assertThat(DrawRequest.valueOf("y")).isInstanceOf(DrawRequest.class);
        assertThat(DrawRequest.valueOf("n")).isInstanceOf(DrawRequest.class);
    }

    @Test
    void 올바르지_않은_요청일_경우_예외가_발생한다() {
        assertAll(
            () -> assertThatThrownBy(() -> DrawRequest.valueOf("no")).isInstanceOf(
                IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> DrawRequest.valueOf("yes")).isInstanceOf(
                IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_요청일_경우_예외가_발생한다() {
        assertAll(
            () -> assertThatThrownBy(() -> DrawRequest.valueOf(" ")).isInstanceOf(
                IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> DrawRequest.valueOf(null)).isInstanceOf(
                IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"y|true", "n|false"}, delimiter = '|')
    void 입력받은_요청에_따라_더_뽑을_수_있는지_확인할_수_있다(String request, boolean result) {
        DrawRequest drawRequest = DrawRequest.valueOf(request);
        assertThat(drawRequest.isDrawable()).isEqualTo(result);
    }
}