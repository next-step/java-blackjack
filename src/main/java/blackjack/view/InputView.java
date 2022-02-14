package blackjack.view;

import java.util.Scanner;

public class InputView {
    private InputView() {}

    public static final String[] readPlayerName() {
        Scanner scanner = new Scanner(System.in);
        try {
            String playerNames = scanner.nextLine();
            return playerNames.split(",");
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
        return readPlayerName();
    }
}
