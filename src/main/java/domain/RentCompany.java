package domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany extends Factory {
    private List<Car> cars;

    @Override
    protected RentCompany createRentCompany() {
        RentCompany rentCompany = new RentCompany();
        rentCompany.cars = new ArrayList<>();
        return rentCompany;
    }

    public String generateReport() {
        return new String();
    }

    public void addCar(CarImpl car) {

    }
}
