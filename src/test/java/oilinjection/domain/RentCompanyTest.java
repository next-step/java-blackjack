package oilinjection.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import oilinjection.domain.vo.RentInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RentCompanyTest {

    @DisplayName("정상적인 렌트카 예약을 받는다.")
    @Test
    void 정상적인_렌트카_예약() {
        final List<RentInfo> reservation = Arrays.asList(
            new RentInfo("avante", 200D),
            new RentInfo("K5", 100D));

        final RentCompany rentCompany = new RentCompany();

        assertDoesNotThrow(() -> rentCompany.acceptReservation(reservation));
    }

    @DisplayName("소유하고 있는 렌트카보다 많은 수를 예약하면 예외를 발생시킨다.")
    @Test
    void 소유한_렌트카_수보다_많은_예약() {
        final List<RentInfo> reservation = Arrays.asList(
            new RentInfo("avante", 200D),
            new RentInfo("avante", 100D));

        final RentCompany rentCompany = new RentCompany();

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> rentCompany.acceptReservation(reservation));
    }
}