package oilinjection;

import java.util.List;
import oilinjection.domain.RentCompany;
import oilinjection.domain.vo.RentInfo;
import oilinjection.util.RentInfoParser;
import oilinjection.view.InputView;
import oilinjection.view.ResultView;

public class OilInjectionApplication {

    public static void main(String[] args) {
        final List<RentInfo> rentInfos = RentInfoParser.parse(InputView.inputReservationInfo());

        final RentCompany rentCompany = new RentCompany();
        rentCompany.acceptReservation(rentInfos);
        ResultView.print(rentCompany.createReport());
    }
}
