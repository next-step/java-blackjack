package rentCompany;

import rentCompany.model.*;
import rentCompany.view.Input;
import rentCompany.view.Output;

public class RentCompanyController {

    public static void main(String[] args) {
        Company company = CompanyFactory.createCompany();

        company.addCar(new K5(Input.inputDistance()));
        company.addCar(new Sonata(Input.inputDistance()));
        company.addCar(new Sonata(Input.inputDistance()));
        company.addCar(new Avante(Input.inputDistance()));
        company.addCar(new Avante(Input.inputDistance()));

        Output.printReport(company.makeReport());
    }
}
