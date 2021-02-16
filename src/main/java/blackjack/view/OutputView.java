package blackjack.view;

import blackjack.domain.Card;
import blackjack.domain.Dealer;
import blackjack.domain.DealerRecord;
import blackjack.domain.GameParticipant;
import blackjack.domain.Player;
import blackjack.dto.PlayerRecordView;

import java.util.List;

public class OutputView {
    public static void beforePrintCards(final GameParticipant participant) {
        String name = participant.getName();
        System.out.print(name + " 카드: ");

        StringBuilder cardsContent = new StringBuilder();
        List<Card> cards = participant.getCardsBeforeGameStart();
        for (final Card card : cards) {
            cardsContent.append(card.getDenomination().getLetter())
                    .append(card.getSuit().getName())
                    .append(", ");
        }
        cardsContent.delete(cardsContent.lastIndexOf(", "), cardsContent.length() - 1);
        System.out.println(cardsContent.toString());
    }

    public static void printCards(final GameParticipant participant) {
        String name = participant.getName();
        System.out.print(name + " 카드: ");

        StringBuilder cardsContent = new StringBuilder();
        List<Card> cards = participant.getCards();
        for (final Card card : cards) {
            cardsContent.append(card.getDenomination().getLetter())
                    .append(card.getSuit().getName())
                    .append(", ");
        }
        cardsContent.delete(cardsContent.lastIndexOf(", "), cardsContent.length() - 1);
        System.out.print(cardsContent.toString());
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printInitializeDealMessage(final Dealer dealer, final List<Player> players) {
        StringBuilder output = new StringBuilder();
        String dealerName = dealer.getName();
        output.append(dealerName)
                .append("와 ");
        for (final Player player : players) {
            output.append(player.getName());
            output.append(", ");
        }
        output.delete(output.lastIndexOf(", "), output.length() - 1);
        output.append("에게 각각 2장의 카드를 나누었습니다.");
        System.out.println(output.toString());
    }

    public static void printDealerAddCardMessage() {
        System.out.println("딜러는 16 이하라 한장의 카드를 더 받았습니다.");
        System.out.println();
    }

    public static void printGameParticipantResultMessage(final GameParticipant gameParticipant) {
        printCards(gameParticipant);
        System.out.print(" - 결과: " + gameParticipant.getResult());
        System.out.println();
    }

    public static void printDealerGameResult(final DealerRecord dealerRecord) {
        System.out.println("딜러: " + dealerRecord.getWin() + "승 " + dealerRecord.getDraw() + "무 " + dealerRecord.getLose() + "패");
    }

    public static void printPlayerGameResult(final PlayerRecordView playerRecordView) {
        System.out.println(playerRecordView.getName() + ": " + playerRecordView.getRecord());
    }

    public static void printRecordFirstLine() {
        System.out.println("## 최종 승패");
    }
}
