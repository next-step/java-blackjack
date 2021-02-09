package oilInjection.controller;

import oilInjection.RentCompany;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OilInjectionControllerTest {

    @Test
    void workingTest() {
        OilInjectionController oilInjectionController = new OilInjectionController();
        oilInjectionController.getDistanceForEachCar(RentCompany.create());
    }
    @DisplayName("distance register test")
    @Test
    void distanceRegisterTest() {
        OilInjectionController oilInjectionController = new OilInjectionController();
        oilInjectionController.getDistanceForEachCar(RentCompany.create());

    }

}