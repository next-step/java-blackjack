package blackjack;

import blackjack.controller.Controller;

import javax.naming.ldap.Control;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.start();
    }
}
