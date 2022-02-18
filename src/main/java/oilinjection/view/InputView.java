package oilinjection.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String RESERVATION_INFO_INPUT_MESSAGE = "대여할 자동차와 예상 거리를 입력해 주세요. (eg. carType1:distance, carType2:distance)";
    private static final String ALL_SPACE = "\\s+";
    private static final String EMPTY_STRING = "";

    private InputView() {}

    public static String inputReservationInfo() {
        System.out.println(RESERVATION_INFO_INPUT_MESSAGE);
        return input();
    }

    private static String input() {
        return removeSpace(SCANNER.nextLine());
    }

    private static String removeSpace(final String input) {
        return input.replaceAll(ALL_SPACE, EMPTY_STRING);
    }
}
