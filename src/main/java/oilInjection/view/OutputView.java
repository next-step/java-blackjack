package oilInjection.view;

import oilInjection.model.Car;

public class OutputView {
    public static void printCarInfo(Car car){
        System.out.println(car.getName() + " : " + car.getOil().getAmount());
    }
}
