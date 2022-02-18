package rentcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import rentcar.domain.RentCar;
import rentcar.domain.RentCompany;
import rentcar.view.InputView;
import rentcar.view.OutputView;

public class Controller {

    public static void run() {
        List<String> rentCar = InputView.inputRentCar();
        List<Integer> distance = InputView.inputDistance();

        RentCompany company = RentCompany.create();
        IntStream.range(0, rentCar.size())
            .forEach(idx -> company.addCar(RentCar.of(rentCar.get(idx), distance.get(idx))));

        OutputView.printReport(company.generateReport());
    }
}
