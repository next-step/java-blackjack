package rentcar.controller;

import rentcar.domain.Avante;
import rentcar.domain.K5;
import rentcar.domain.RentCompany;
import rentcar.domain.Sonata;
import rentcar.view.InputView;
import rentcar.view.OutputView;

public class RentCarController {

    private RentCompany rentCompany;

    public void startService() {
        initService();
        printReport();
    }

    private void initService() {
        int distance = InputView.getCustomInput();
        rentCompany = new RentCompany();
        rentCompany.addCar(new Sonata(distance));
        rentCompany.addCar(new Avante(distance));
        rentCompany.addCar(new K5(distance));
    }

    private void printReport() {
        OutputView.printReport(rentCompany.generateReport());
    }
}
