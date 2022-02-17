package fuel.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static Double readDistance() {
        Double carDistance = scanner.nextDouble();
        return carDistance;
    }
}
