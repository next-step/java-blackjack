package rentcar;

import rentcar.controller.RentCarController;

public class RentCarApplication {

    public static void main(String[] args) {
        RentCarController rentCarController = new RentCarController();
        rentCarController.startService();
    }
}
