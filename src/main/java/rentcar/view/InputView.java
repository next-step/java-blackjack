package rentcar.view;

import java.util.Scanner;

public class InputView {

    private final static String INFO_RENT_CAR_INPUT = "여행할 목적지의 이동거리를 입력해주세요.";
    private final static Scanner scanner = new Scanner(System.in);

    public static int getCustomInput() {
        System.out.println(INFO_RENT_CAR_INPUT);
        String input = scanner.next();
        int distance = Integer.valueOf(input);
        return distance;
    }
}
