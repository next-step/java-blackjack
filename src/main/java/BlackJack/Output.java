package BlackJack;

import java.util.ArrayList;
import java.util.List;

public class Output {

    private static List<String> makeCardStatus(List<Card> holdingCards) {
        List<String> cardStatus = new ArrayList<>();
        int holdingCardsSize = holdingCards.size();
        for (int i = 0; i < holdingCardsSize; i++) {
            cardStatus.add(holdingCards.get(i).getCardNumber().getOutputScore() + holdingCards.get(i).getCardShape());
        }
        return cardStatus;
    }

    public static void showCardStatus(List<Card> holdingCards) {
        System.out.println(String.join(", ", makeCardStatus(holdingCards)));
    }

    public static void showCardStatus2(List<Card> holdingCards, int sumCards) {
        System.out.println(String.join(", ", makeCardStatus(holdingCards)) + "- 결과: " + sumCards);
    }
}
