package rentCompany.view;

import java.util.Scanner;

public class Input {
    private final static Scanner scanner = new Scanner(System.in);

    public static int inputDistance() {
        System.out.println("거리를 입력하세요.");

        return scanner.nextInt();
    }
}
