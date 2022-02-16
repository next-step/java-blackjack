package blackJack.view;

import blackJack.util.Console;

public class InputView {

    public static boolean readYN(String name) {
        String yn = "";
        try {
            System.out.print(name + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n) ");
            yn = Console.readLine();
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
        }
        return yn.equals("y");
    }
}
