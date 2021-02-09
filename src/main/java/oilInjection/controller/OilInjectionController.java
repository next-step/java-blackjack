package oilInjection.controller;

import oilInjection.RentCompany;
import oilInjection.model.Car;
import view.InputView;

import java.util.List;

public class OilInjectionController {


    public void getDistanceForEachCar(RentCompany rentCompany) {
        System.out.println("차 별 원하는 거리를 입력하세요.");
       for (Car car : rentCompany.getCarList()) {
           System.out.println(car.getName());
           car.registerTripDistance(InputView.getDistance());
       }
    }
}
