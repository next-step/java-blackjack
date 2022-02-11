package fuel;

import fuel.domain.Avante;
import fuel.domain.K5;
import fuel.domain.RentCompany;
import fuel.domain.Sonata;
import fuel.view.InputView;
import fuel.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RentCompany rentCompany = new RentCompany();

        OutputView.printSonataDistance();
        rentCompany.addCar(new Sonata(InputView.readDistance()));

        OutputView.printK5Distance();
        rentCompany.addCar(new K5(InputView.readDistance()));

        OutputView.printSonataDistance();
        rentCompany.addCar(new Sonata(InputView.readDistance()));

        OutputView.printAvanteDistance();
        rentCompany.addCar(new Avante(InputView.readDistance()));

        OutputView.printK5Distance();
        rentCompany.addCar(new K5(InputView.readDistance()));

        OutputView.printReport(rentCompany.generateReport());
    }
}
