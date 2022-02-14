package rentcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, Double> generateChargeQuantityByName() {
        Map<String, Double> map = new HashMap<>();

        for (Car car : cars) {
            String name = car.getCarName();
            double chargeQuantity = car.getChargeQuantity();

            map.put(name, chargeQuantity);
        }
        return map;
    }
}
