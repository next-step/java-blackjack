package BlackJack;

import BlackJack.actor.Player;
import BlackJack.game.PlayGame;

import java.util.Scanner;

public class Input {

    private static Scanner in = new Scanner(System.in);

    public static String insertPlayerName() {
        return in.nextLine();
    }
    public static String agreement(){
        return in.nextLine();
    }
    public static boolean isDraw(String agreement, Player player, PlayGame playGame) {
            return agreement.equals("y");
    }

}
