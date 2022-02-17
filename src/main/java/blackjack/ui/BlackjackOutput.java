package blackjack.ui;

import blackjack.domain.Player;

public class BlackjackOutput {

    public static void printPlayerCard(Player player){
        System.out.println(player.getName() + "카드: ");
    }
}
