package rentcar;

import org.junit.jupiter.api.Test;

public class CompanyTest {
    @Test
    void name() {
        RentCompany rentCompany = RentCompany.create();
        rentCompany.generateReport();
    }
}
