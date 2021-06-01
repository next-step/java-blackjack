package rentCompany.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompanyCars {
    private final List<Car> cars;

    public CompanyCars() {
        this.cars = new ArrayList<>();
    }

    public void add(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
