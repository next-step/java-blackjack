package oilInjection.view;

import oilInjection.model.Distance;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String GET_DISTANCE_MESSAGE = "차 별 원하는 거리를 입력하세요.";
    public static double getDistance() {
        return Double.parseDouble(scanner.nextLine());
    }

    public static void printGetDistanceMessage() {
        System.out.println(GET_DISTANCE_MESSAGE);
    }

}
