package oilInjection.controller;

import oilInjection.RentCompany;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OilInjectionControllerTest {

    @Test
    void working_test() {
        OilInjectionController oilInjectionController = new OilInjectionController();
        oilInjectionController.getDistanceForEachCar(RentCompany.create());

    }

}