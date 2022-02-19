package rentcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private final List<Car> cars;
    private final Report report;

    public RentCompany() {
        this.cars = new ArrayList<>();
        this.report = new Report();
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
