package rentcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String LITER = "리터";

    private List<Car> carList;

    public RentCompany() {
        carList = new ArrayList<>();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void addCars(List<Car> carList) {
        this.carList = carList;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();
        for(Car car : carList){
            report.append(car.getName()+" : "+(int)car.getChargeQuantity()+ LITER + NEW_LINE);
        }
        System.out.println(report);
        return report.toString();
    }
}
