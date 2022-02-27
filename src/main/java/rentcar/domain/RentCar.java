package rentcar.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

public enum RentCar {
    SONATA("Sonata", Sonata::new),
    AVANTE("Avante", Avante::new),
    K5("K5", K5::new);

    private final String rentCarName;
    private final Function<Double, Object> function;

    RentCar(String rentCarName, final Function<Double, Object> function) {
        this.rentCarName = rentCarName;
        this.function = function;
    }

    public static Car of(final String rentCarName, final double distance) {
        return (Car) Objects.requireNonNull(Arrays.stream(values())
            .filter(car -> Objects.equals(car.rentCarName, rentCarName))
            .findAny().orElse(null)).apply(distance);
    }

    private Object apply(final double distance) {
        return function.apply(distance);
    }
}