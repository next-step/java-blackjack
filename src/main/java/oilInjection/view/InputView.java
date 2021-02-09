package oilInjection.view;

import oilInjection.model.Distance;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Distance getDistance() {
        String distance = scanner.nextLine();
        return Distance.of(Double.parseDouble(distance));
    }
}
