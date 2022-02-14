package oilinjection.domain;

import java.util.Arrays;
import java.util.function.Function;
import oilinjection.domain.car.Avante;
import oilinjection.domain.car.Car;
import oilinjection.domain.car.K5;
import oilinjection.domain.car.Sonata;

public enum CarFactory {
    AVANTE("AVANTE", Avante::new),
    SONATA("SONATA", Sonata::new),
    K5("K5", K5::new);

    private static final double MIN_TRIP_DISTANCE = 1D;
    private static final String UNDER_MIN_TRIP_DISTANCE_EXCEPTION_MESSAGE = "[ERROR] 해당하는 차종이 없습니다.";
    private static final String NOT_FOUND_NAME_EXCEPTION_MESSAGE = "[ERROR] 해당하는 차종이 없습니다.";
    private final String name;
    private final Function<Double, Car> createCar;

    CarFactory(final String name, final Function<Double, Car> createCar) {
        this.name = name;
        this.createCar = createCar;
    }

    public static Car create(final String name, final double tripDistance) {
        validateOverMinTripDistance(tripDistance);

        return Arrays.stream(values())
            .filter(car -> car.name.equals(name.toUpperCase()))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_NAME_EXCEPTION_MESSAGE))
            .createCar(tripDistance);
    }

    private static void validateOverMinTripDistance(double tripDistance) {
        if (tripDistance < MIN_TRIP_DISTANCE) {
            throw new IllegalArgumentException(UNDER_MIN_TRIP_DISTANCE_EXCEPTION_MESSAGE);
        }
    }

    private Car createCar(final double tripDistance) {
        return this.createCar.apply(tripDistance);
    }
}
