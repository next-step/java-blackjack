package controller;

import domain.RentCompany;
import view.InputView;
import view.ReportView;

public class RentController {

    public void start() {
        RentCompany rentCompany = RentCompany.create(InputView.getTripDistance());

        ReportView.generateReport(rentCompany.generateChargeQuantityByName());
    }
}
