package blackjack.view;

import blackjack.model.Players;

public class OutputView {

    public void initialPopCard(final Players players) {
        final String gamer = players.getPlayerNames(player -> !player.getName().equals("Dealer"));
        final String dealer = players.getPlayerNames(player -> player.getName().equals("Dealer"));
        final String printResult = String.format("%s와 %s에게 2장을 나누었습니다.", dealer, gamer);
        System.out.println(printResult);
    }
}
