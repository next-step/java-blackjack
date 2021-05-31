package rentCompany;

import java.util.Arrays;
import java.util.List;

public class Company {
    private final CompanyCars companyCars;

    public Company() {
        this.companyCars = new CompanyCars(Arrays.asList( new K5(),
                new Sonata(),
                new Sonata(),
                new Avante(),
                new Avante()));
    }

    public List<Car> getCars() {
        return companyCars.getCars();
    }
}
