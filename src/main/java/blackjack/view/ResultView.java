package blackjack.view;

import blackjack.domain.card.Card;
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
        List<String> cardNames = player.getCards().stream()
            .map(card -> card.getDenomination().getValue() + card.getShape().getName())
            .collect(Collectors.toList());
        System.out.println(String.join(", ", cardNames));
    }
}
