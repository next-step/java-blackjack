package rentCompany;

import java.util.Collections;
import java.util.List;

public class CompanyCars {
    private final List<Car> cars;

    public CompanyCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
