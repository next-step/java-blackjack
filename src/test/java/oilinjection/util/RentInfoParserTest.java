package oilinjection.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import oilinjection.domain.vo.RentInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class RentInfoParserTest {

    @DisplayName("올바른 입력이 들어오면, 정상적으로 실행된다.")
    @Test
    void 정상_입력1() {
        final String input = "car1:200";
        final RentInfo rent = new RentInfo("car1", 200);
        assertThat(RentInfoParser.parse(input)).isEqualTo(Arrays.asList(rent));
    }

    @DisplayName("두 개 이상의 rent 정보가 올바른 입력 형식으로 들어와도 정상적으로 실행된다.")
    @Test
    void 정상_입력2() {
        final String input = "car1:200,car2:300";
        final List<RentInfo> rents = Arrays.asList(new RentInfo("car1", 200), new RentInfo("car2", 300));
        assertThat(RentInfoParser.parse(input)).isEqualTo(rents);
    }

    @DisplayName("입력이 빈 값이면 예외가 발생한다.")
    @EmptySource
    @ParameterizedTest
    void 빈_입력_예외_발생(final String input) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> RentInfoParser.parse(input));
    }

    @DisplayName("랜트 정보 값이 하나로도 빈 값이면 예외가 발생한다.")
    @ValueSource(strings = {"car1:", ":200"})
    @ParameterizedTest
    void 렌트_정보_중_하나의_빈_입력_예외_발생(final String input) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> RentInfoParser.parse(input));
    }

    @DisplayName("랜트 정보 중 거리 값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 거리_값이_숫자가_아닌_경우_예외_발생() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> RentInfoParser.parse("car:aaa"));
    }

    @DisplayName("입력 형식에 맞지 않는 경우 예외가 발생한다.")
    @ValueSource(strings = {"car1 200", "car1,200", "card1200", "car::123"})
    @ParameterizedTest
    void 입력_형식에_맞지_않는_경우_예외_발생(final String input) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> RentInfoParser.parse(input));
    }
}
