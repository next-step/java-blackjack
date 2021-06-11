package BlackJack;

import java.util.Scanner;

public class Input {

    private static Scanner in = new Scanner(System.in);

    public static String insertPlayerName() {
        return in.nextLine();
    }
    public static String agreement(){
        return in.nextLine();
    }
}
