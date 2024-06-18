package view;

import java.util.Scanner;

public class inputView {
    public static String[] inputPlayerNames() {
        Scanner scanner = new Scanner(System.in);
        String playerNames = scanner.nextLine();
        return playerNames.split(",");
    }

    public static int inputPlayerBettingPrice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


    public static boolean inputIsMoreCard() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equals("y")){
            return true;
        }
        return false;
    }
}
