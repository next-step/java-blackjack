package rentcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String RENT_CAR_TYPE_MESSAGE = "렌트할 차를 입력해주세요.";
    private static final String RENT_CAR_DISTANCE_MESSAGE = "차량별 이동거리를 입력해주세요.";


    public static String inputRentCar(){
        System.out.println(RENT_CAR_TYPE_MESSAGE);
        return SCANNER.nextLine();
    }

    public static String inputDistance(){
        System.out.println(RENT_CAR_DISTANCE_MESSAGE);
       return SCANNER.nextLine();
    }
}
