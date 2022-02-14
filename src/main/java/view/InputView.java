package view;

import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);
    private final static String TRIP_MANAGER = "여행 거리를 입력해 주세요.";
    private final static String ERROR_LOG = "[ERROR] 0이나 빈 값이 들어올 수 없습니다";

    public static int getTripDistance() {
        try {
            System.out.println(TRIP_MANAGER);
            String input = scanner.nextLine();
            validateEmptyOrZero(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getTripDistance();
        }
    }

    private static void validateEmptyOrZero(String input) {
        if (input.trim().isEmpty() || input.equals("0")) {
            throw new IllegalArgumentException(ERROR_LOG);
        }
    }
}
