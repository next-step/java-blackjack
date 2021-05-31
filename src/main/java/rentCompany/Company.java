package rentCompany;

import java.util.List;

public class Company {
    private final CompanyCars companyCars;

    public Company(CompanyCars companyCars) {
        this.companyCars = companyCars;
    }

    public List<Car> getCars() {
        return companyCars.getCars();
    }
}
