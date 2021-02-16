package fuel.view;

import java.util.Scanner;

public class InputView {
    private final String GET_DISTANCE_MESSAGE = "여행할 목적지의 대략적인 이동거리를 입력해주세요.";
    private final String GET_KIND_OF_CAR_MESSAGE = "원하는 자동차 종류를 입력해주세요(Sonata, Avante, K5).";

    public int getDistance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(GET_DISTANCE_MESSAGE);
        return scanner.nextInt();
    }

    public String getKindOfCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(GET_KIND_OF_CAR_MESSAGE);
        return scanner.nextLine();
    }
}
