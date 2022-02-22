package oilinjection.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import oilinjection.domain.vo.RentInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RentCompanyTest {

    private static final String NEWLINE = System.getProperty("line.separator");

    @DisplayName("정상적인 렌트카 예약을 받는다.")
    @Test
    void 정상적인_렌트카_예약() {
        final List<RentInfo> reservation = Arrays.asList(
            new RentInfo("avante", 200D),
            new RentInfo("K5", 100D));

        final RentCompany rentCompany = new RentCompany();

        assertDoesNotThrow(() -> rentCompany.acceptReservation(reservation));
    }

    @DisplayName("렌트카 회사에서 갖고 있지 않은 자동차 종류에 관한 예약이 들어올 경우 예외 처리한다. ")
    @Test
    void givenWrongTypeOfCar_whenReservation_thenException() {
        final List<RentInfo> reservation = Arrays.asList(
            new RentInfo("avante", 200D),
            new RentInfo("K6", 100D));

        final RentCompany rentCompany = new RentCompany();
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> rentCompany.acceptReservation(reservation));
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

    @DisplayName("차량별로 주입해야할 연료량을 확인할 수 있는 보고서를 생성한다.")
    @Test
    void 보고서_생성() {
        final List<RentInfo> reservation = Arrays.asList(
            new RentInfo("Avante", 20D),
            new RentInfo("Sonata", 300D),
            new RentInfo("Sonata", 150D),
            new RentInfo("K5", 130D),
            new RentInfo("K5", 390D));

        final RentCompany rentCompany = new RentCompany();
        rentCompany.acceptReservation(reservation);
        String report = rentCompany.createReport();

        assertThat(report).isEqualTo(
            "Avante : 2리터" + NEWLINE +
            "Sonata : 30리터" + NEWLINE +
            "Sonata : 15리터" + NEWLINE +
            "K5 : 10리터" + NEWLINE +
            "K5 : 30리터" + NEWLINE
        );
    }
}
