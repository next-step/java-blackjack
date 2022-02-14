package domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private final List<Car> cars;

    public RentCompany(List<Car> cars) {
        this.cars = cars;
    }

    public static RentCompany create(int distance) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Avante(distance));
        cars.add(new K5(distance));
        cars.add(new Sonata(distance));
        return new RentCompany(cars);
    }
}
