package fuel.controller;

import fuel.domain.RentCompany;
import fuel.view.InputView;
import fuel.view.OutputView;

public class RentCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RentCarController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void useRentCompany(RentCompany rentCompany) {
        String kindOfCar = inputView.getKindOfCar();
        int distance = inputView.getDistance();
        rentCompany.reservation(kindOfCar, distance);
    }

    public void outputReport(RentCompany rentCompany) {
        String report = rentCompany.generateReport();
        outputView.printReport(report);
    }
}
