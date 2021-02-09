package oilInjection;

import oilInjection.controller.OilInjectionController;
import oilInjection.model.RentCompany;

public class OilMain {
    public static void main(String[] args) {
        OilInjectionController oilInjectionController = new OilInjectionController();
        RentCompany rentCompany = RentCompany.create();
        oilInjectionController.getDistanceForEachCar(rentCompany);
        oilInjectionController.makeOilReport(rentCompany);
    }
}
