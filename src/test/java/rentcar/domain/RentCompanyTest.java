package rentcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RentCompanyTest {

    @DisplayName("RentCompany_객체_생성_테스트")
    @Test
    public void createRentCarTest() {
        RentCompany company = RentCompany.create();
        assertThat(company).isNotNull();
    }
}