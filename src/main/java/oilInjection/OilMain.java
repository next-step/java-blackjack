package oilInjection;

import oilInjection.controller.OilInjectionController;

public class OilMain {
    public static void main(String[] args) {
        OilInjectionController oil = new OilInjectionController();
        oil.getDistanceForEachCar(RentCompany.create());
    }
}
