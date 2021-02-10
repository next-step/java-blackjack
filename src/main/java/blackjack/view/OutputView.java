package blackjack.view;

import blackjack.model.Card;
import blackjack.model.Player;

public class OutputView {
    public static void outputPlayerStatus(Player player){
        System.out.println(player.toString());
    }
}
