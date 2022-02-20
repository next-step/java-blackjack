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
    private static final String NO_TYPE_EXCEPTION_MESSAGE_FORMAT = "[ERROR] %s 자동차는 회사에 존재하지 않습니다.";

    private final List<Car> rents;

    public RentCompany() {
        this.rents = new ArrayList<>();
    }

    public void acceptReservation(final List<RentInfo> rentInfos) {
        validateIsPossibleReservation(rentInfos);
        rents.addAll(Collections.unmodifiableList(rentInfos.stream()
            .map(this::rent)
            .collect(Collectors.toList())));
    }

    private Car rent(RentInfo rentInfo) {
        return RentCar.rent(rentInfo.getType(), rentInfo.getTripDistance());
    }

    private void validateIsPossibleReservation(final List<RentInfo> rentInfos) {
        rentInfos.stream()
            .collect(Collectors.groupingBy(RentInfo::getType, Collectors.summingInt(x -> 1)))
            .forEach(this::validatePerCarType);
    }

    private void validatePerCarType(final String type, final int count) {
        if (findRentCar(type).isImpossibleReservation(count)) {
            throw new IllegalArgumentException(
                String.format(QUANTITY_OVER_EXCEPTION_MESSAGE_FORMAT, type));
        }
    }

    private RentCar findRentCar(final String type) {
        try {
            return RentCar.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                String.format(NO_TYPE_EXCEPTION_MESSAGE_FORMAT, type));
        }
    }

    public String createReport() {
        StringBuilder report = new StringBuilder();
        rents.forEach(car -> report.append(
            String.format(REPORT_FORMAT, car.getType(), car.getChargeQuantity())));

        return report.toString();
    }
}
