package rentcar.controller;

import rentcar.domain.RentCompany;
import rentcar.view.InputView;
import rentcar.view.ReportView;

public class RentController {

    public void start() {
        RentCompany rentCompany = new RentCompany();
        rentCompany.receive(InputView.getTripDistance());

        ReportView.generateReport(rentCompany.generateChargeQuantityByName());
    }
}
