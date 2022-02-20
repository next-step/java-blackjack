package rentcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private final Report report = new Report();
    private final List<Car> cars;

    public RentCompany() {
        this(new ArrayList<>());
    }

    public RentCompany(final List<Car> cars) {
        this.cars = cars;
    }

    public void receive(final int distance) {
        cars.add(new Avante(distance));
        cars.add(new K5(distance));
        cars.add(new Sonata(distance));
    }

    public Report generateChargeQuantityByName() {
        cars
            .forEach(car -> report.putDetails(car));
        return report;
    }
}
