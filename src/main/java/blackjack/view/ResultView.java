package blackjack.view;

import blackjack.domain.card.Card;
import blackjack.domain.cards.DealerCards;
import blackjack.domain.game.GameResult;
import blackjack.domain.person.Player;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printSetUpResult(Card openedCard, List<Player> players) {
        List<String> playerNames = players.stream().map(Player::getName).collect(Collectors.toList());
        System.out.println("딜러와 " + String.join(", ", playerNames) + "에게 2장씩 나눠줬습니다.");
        System.out.println("딜러: " + openedCard.getDenomination().getValue() + openedCard.getShape().getName());
        players.forEach(ResultView::printCardsOf);
    }

    public static void printCardsOf(Player player) {
        System.out.print(player.getName() + "카드: ");
        List<String> cardNames = player.getPlayerCards().getCards().stream()
            .map(card -> card.getDenomination().getValue() + card.getShape().getName())
            .collect(Collectors.toList());
        System.out.println(String.join(", ", cardNames));
    }

    public static void printDealerReceiveCard() {
        System.out.println("딜러는 16 이하라 한 장의 카드를 더 받았습니다.");
    }


    public static void printDealerAndPlayerCardResult(DealerCards dealerCards, List<Player> players) {
        System.out.print("딜러 카드: ");
        List<String> dealerCardNames = dealerCards.getCards().stream()
            .map(card -> card.getDenomination().getValue() + card.getShape().getName())
            .collect(Collectors.toList());
        System.out.println(String.join(", ", dealerCardNames) + " - 결과 : " + dealerCards.getSumOfCards());

        for (Player player : players) {
            System.out.print(player.getName() + "카드: ");
            List<String> playerCardNames = player.getPlayerCards().getCards().stream()
                .map(card -> card.getDenomination().getValue() + card.getShape().getName())
                .collect(Collectors.toList());
            System.out.println(
                String.join(", ", playerCardNames) + "- 결과 : " + player.getPlayerCards().getSumOfCards());
        }
    }

    public static void printGameResult(GameResult gameResult) {
        System.out.println("## 최종승패");
        System.out.println("딜러: " + gameResult.getDealerWin() + "승 " + (gameResult.getPlayerResult().size()
            - gameResult.getDealerWin()) + "패");
        gameResult.getPlayerResult().keySet()
            .forEach(playerName -> {
                System.out.println(playerName + ": " + gameResult.getPlayerResult().get(playerName));
            });
    }
}
