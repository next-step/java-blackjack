package fuelInjection;

import fuelInjection.domain.Car;
import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private final List<Car> rentCars;

    private RentCompany() {
        this.rentCars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public List<Car> getRentCars() {
        return rentCars;
    }
}
