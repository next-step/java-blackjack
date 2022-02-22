package rentcar.controller;

import rentcar.domain.RentCompany;
import rentcar.view.InputView;
import rentcar.view.ReportView;

public class RentController {

    public void start() {
        RentCompany rentCompany = RentCompany.create(InputView.getTripDistance());

        ReportView.generateReport(rentCompany.generateChargeQuantityByName());
    }
}
