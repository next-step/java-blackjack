package rentCompany.model;

import java.util.List;
import java.util.stream.Collectors;

public class Company {
    public static final String NEW_LINE = System.getProperty("line.separator");
    private static final String SEPARATOR = " : ";
    private static final String LITER = "리터";

    private final CompanyCars companyCars = new CompanyCars();

    public Company() {
    }

    public void addCar(Car car) {
        companyCars.add(car);
    }

    public StringBuilder makeReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(
                getCars().stream()
                        .map((car) -> makeCarInformation(car))
                        .collect(Collectors.joining())
        );

        return stringBuilder;
    }

    private StringBuilder makeCarInformation(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(car.getName())
                .append(SEPARATOR)
                .append(car.getFuelRequiredAmount())
                .append(LITER)
                .append(NEW_LINE);

        return stringBuilder;
    }

    public List<Car> getCars() {
        return companyCars.getCars();
    }
}
