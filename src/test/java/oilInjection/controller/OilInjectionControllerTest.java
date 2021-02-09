package oilInjection.controller;

import oilInjection.model.RentCompany;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OilInjectionControllerTest {

    @Test
    void workingTest() {
        OilInjectionController oilInjectionController = new OilInjectionController();
        RentCompany rentCompany = RentCompany.create();
        oilInjectionController.getDistanceForEachCar(rentCompany);
        oilInjectionController.makeOilReport(rentCompany);
    }

    @DisplayName("distance register test")
    @Test
    void distanceRegisterTest() {
        OilInjectionController oilInjectionController = new OilInjectionController();
        oilInjectionController.getDistanceForEachCar(RentCompany.create());

    }

}