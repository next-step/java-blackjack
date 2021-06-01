package rentCompany.model;

import java.util.List;

public class Company {
    private final CompanyCars companyCars = new CompanyCars();

    public Company() {

    }

    public void addCar(Car car) {
        companyCars.add(car);
    }

    public List<Car> getCars() {
        return companyCars.getCars();
    }
}
