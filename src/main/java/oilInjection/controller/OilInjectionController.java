package oilInjection.controller;

import oilInjection.model.RentCompany;
import oilInjection.model.Car;
import oilInjection.view.InputView;
import oilInjection.view.OutputView;

public class OilInjectionController {


    public void getDistanceForEachCar(RentCompany rentCompany) {
       InputView.printGetDistanceMessage();
       for (Car car : rentCompany.getCarList()) {
           OutputView.printCarName(car.getName());
           car.registerTripDistance(InputView.getDistance());
           car.injectOil();
       }
    }

    public void makeOilReport(RentCompany rentCompany){
        OutputView.printCarInfo(rentCompany.generateReport());
    }
}
