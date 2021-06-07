package blackjack.view;

import blackjack.service.Player;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void resultStartCard(List<Player> players) {
        System.out.println("모두에게 2장을 나누었습니다,");

        resultPlayers(players);
    }


    public void resultPlayers(List<Player> players){
        players.forEach(this::resultPlayer);//player -> resultPlayer(player)
    }

    public void resultPlayer(Player player) {
        System.out.println(player.getName() + " : " +
                player.getCards()
                        .stream()
                        .map(card -> card.getCardPattern().getMark() + card.getCardNumber().getMark())
                        .collect(Collectors.joining(",")));
    }

    public void resultFinalCard(List<Player> players){
        players.forEach(player -> System.out.println(player.getName() + " : " +
                player.getCards()
                        .stream()
                        .map(card -> card.getCardPattern().getMark() + card.getCardNumber().getMark())
                        .collect(Collectors.joining(","))
                +"-결과"+player.getScore())
                        );

    }

    public void resultFinal(List<Player> players){
        System.out.println("##최종 승패");

    }


    public void resultDealer(){
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }


}
