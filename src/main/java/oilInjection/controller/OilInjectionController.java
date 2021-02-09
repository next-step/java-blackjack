package oilInjection.controller;

import oilInjection.RentCompany;
import oilInjection.model.Car;
import view.InputView;
import view.OutputView;

public class OilInjectionController {


    public void getDistanceForEachCar(RentCompany rentCompany) {
        System.out.println("차 별 원하는 거리를 입력하세요.");
       for (Car car : rentCompany.getCarList()) {
           System.out.println(car.getName());
           car.registerTripDistance(InputView.getDistance());
           car.injectOil();
       }
    }

    public void makeOilReport(RentCompany rentCompany){
        rentCompany.getCarList()
                .forEach(OutputView::printCarInfo);
    }
}
