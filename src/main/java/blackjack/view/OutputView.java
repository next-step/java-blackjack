package blackjack.view;

import static blackjack.domain.user.Players.START_CARD_INIT_SIZE;

import blackjack.domain.card.Card;
import blackjack.domain.user.Player;
import blackjack.domain.user.Players;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {
    }

    public static void printAllPlayersCard(Players players) {
        List<Player> candiates = players.findOnlyPlayers();
        Player dealer = players.findDealer();
        System.out.printf("\n딜러와 %s에게 %d장 나누었습니다.\n", collectPlayerNames(candiates),
            START_CARD_INIT_SIZE);
        System.out.printf("%s : %s\n", dealer.name(), collectDealerCard(dealer));
        candiates.forEach(OutputView::printEachCardInfo);
        System.out.println();
    }

    public static void printEachCardInfo(Player player) {
        System.out.printf("%s : %s\n", player.name(), collectPlayerCard(player));
    }

    private static String collectPlayerNames(List<Player> candiates) {
        return candiates.stream()
            .map(Player::name)
            .collect(Collectors.joining(","));
    }

    private static String collectDealerCard(Player dealer) {
        List<Card> cards = dealer.getCardBundle();
        return makeCardInfo(cards.get(0));
    }

    private static String makeCardInfo(Card card) {
        return String.join("", card.message(), card.suit());
    }

    private static String collectPlayerCard(Player player) {
        List<Card> cards = player.getCardBundle();
        return cards.stream()
            .map(OutputView::makeCardInfo)
            .collect(Collectors.joining(", "));
    }
}
