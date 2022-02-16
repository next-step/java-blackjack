package blackJack.view;

import blackJack.util.Console;

public class InputView {

    public static boolean readYN() {
        String yn = "";
        try {
            yn = Console.readLine();
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
        }
        return yn.equals("y");
    }

    public static String readPlayerName() {
        return Console.readLine();
    }
}
