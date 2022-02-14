package oilinjection.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import oilinjection.domain.car.Car;
import oilinjection.domain.vo.RentInfo;

public class RentCompany {

    private static final String QUANTITY_OVER_EXCEPTION_MESSAGE_FORMAT = "[ERROR] %s의 예약 가능한 차량이 없습니다.";
    private static final String REPORT_FORMAT = "%s : %.0f리터%n";

    private final List<Car> rents;

    public RentCompany() {
        this.rents = new ArrayList<>();
    }

    public void acceptReservation(final List<RentInfo> rentInfos) {
        validateIsPossibleReservation(rentInfos);

        final List<Car> rentCars = rentInfos.stream()
            .map(rentInfo -> RentCar.rent(rentInfo.getName(), rentInfo.getTripDistance()))
            .collect(Collectors.toList());

        rents.addAll(Collections.unmodifiableList(rentCars));
    }

    private void validateIsPossibleReservation(final List<RentInfo> rentInfos) {
        rentInfos.stream()
            .collect(Collectors.groupingBy(RentInfo::getName, Collectors.summingInt(x -> 1)))
            .forEach(this::validatePerCarType);
    }

    private void validatePerCarType(final String name, final Integer count) {
        if (findRentCar(name).isImpossibleReservation(count)) {
            throw new IllegalArgumentException(
                String.format(QUANTITY_OVER_EXCEPTION_MESSAGE_FORMAT, name));
        }
    }

    private RentCar findRentCar(final String name) {
        return RentCar.valueOf(name.toUpperCase());
    }

    public String createReport() {
        StringBuilder report = new StringBuilder();
        rents.forEach(car -> report.append(String.format(REPORT_FORMAT, car.getName(), car.getChargeQuantity())));
        return report.toString();

    }
}
