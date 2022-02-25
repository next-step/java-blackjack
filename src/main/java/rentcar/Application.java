package rentcar;

import rentcar.controller.RentController;

public class Application {

    public static void main(String[] args) {
        RentController rentController = new RentController();
        rentController.start();
    }
}
