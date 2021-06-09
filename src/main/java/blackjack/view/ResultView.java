package blackjack.view;

import blackjack.service.Player;
import blackjack.service.Players;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void resultStartCard(Players players) {
        System.out.print("딜러와 ");
        System.out.print(players.getPlayers().stream().filter(player->player.isGamer()).map(player -> player.getName()).collect(Collectors.joining(",")));
        System.out.println("에게 2장을 나누었습니다,");

        resultPlayers(players);
    }
    public void resultPlayers(Players players) {
        players.getPlayers().forEach(this::resultPlayer);//player -> resultPlayer(player)
    }

    public void resultPlayer(Player player) {
        System.out.println(player.getName() + " : " +
                player.getCards()
                        .stream()
                        .map(card -> card.getCardPattern().getMark() + card.getCardNumber().getMark())
                        .collect(Collectors.joining(",")));
    }

    public void resultFinalCard(Players players) {
        players.getPlayers().forEach(player -> System.out.println(player.getName() + " : " +
                player.getCards()
                        .stream()
                        .map(card -> card.getCardPattern().getMark() + card.getCardNumber().getMark())
                        .collect(Collectors.joining(","))
                + "-결과" + player.getScore())
        );

    }

    public void resultFinal() {
        System.out.println("##최종 승패");

    }

    public void resultDealer() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }


}
