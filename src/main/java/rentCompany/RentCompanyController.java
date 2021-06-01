package rentCompany;

import rentCompany.model.*;
import rentCompany.view.InputView;
import rentCompany.view.Output;

public class RentCompanyController {

    public static void main(String[] args) {
        Company company = CompanyFactory.createCompany();

        company.addCar(new K5(InputView.inputDistance()));
        company.addCar(new Sonata(InputView.inputDistance()));
        company.addCar(new Sonata(InputView.inputDistance()));
        company.addCar(new Avante(InputView.inputDistance()));
        company.addCar(new Avante(InputView.inputDistance()));

        Output.printReport(company.makeReport());
    }
}
