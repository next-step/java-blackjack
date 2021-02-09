package oilInjection.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CarTest {


    @Test
    void registerTripDistanceTest() {
        RentCompany rentCompany = RentCompany.create();
        Car car = rentCompany.getCarList().get(0);

        double expectedDistance = 150;
        car.registerTripDistance(Distance.of(expectedDistance));
        assertThat(car.getTripDistance()).isEqualTo(Distance.of(expectedDistance));

    }
}