package rentcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String RENT_CAR_TYPE_MESSAGE = "Sonata, K5, Avante 중 렌트할 차 타입을 콤마(,) 기준으로 연속해서 입력해주세요.";
    private static final String RENT_CAR_DISTANCE_MESSAGE = "차량별 이동거리를 입력해주세요.";


    public static List<String> inputRentCar() {
        System.out.println(RENT_CAR_TYPE_MESSAGE);
        return Arrays.stream(SCANNER.nextLine().split(","))
            .map(String::trim)
            .collect(Collectors.toList());
    }

    public static List<Integer> inputDistance() {
        System.out.println(RENT_CAR_DISTANCE_MESSAGE);
        return Arrays.stream(SCANNER.nextLine().split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
