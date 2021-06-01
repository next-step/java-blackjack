package blackjack.view;

import blackjack.service.Card;
import blackjack.service.Player;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void resultStartCard(List<Player> players) {
        System.out.println("모두에게 2장을 나누었습니다,");

        players.forEach(this::resultCard);//player -> result(player)
    }


    public void resultCard(Player player){
        System.out.println(player.getName() + " : " +
                player.getCards()
                        .stream()
                        .map(card -> card.getCardPattern().getMark() + card.getCardNumber().getMark())
                        .collect(Collectors.joining(",")));
    }
}
