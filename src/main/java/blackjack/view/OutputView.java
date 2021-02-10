package blackjack.view;

import blackjack.dto.CardBunchInfo;
import blackjack.dto.CardInfo;
import blackjack.dto.NameInfo;
import blackjack.dto.PersonInfo;

import java.util.List;
import java.util.Map;


public class OutputView {

    public void printCardInfo(PersonInfo personInfo) {
        System.out.printf("%s: %s\n",
            personInfo.getNameInfo().getName(),
            getCardInfo(personInfo.getCardBunchInfo())
        );

    }

    private String getCardInfo(CardBunchInfo cardBunchInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        for (CardInfo card : cardBunchInfo.getCardsInfo()) {
            stringBuilder.append(card.getDenomination().getName())
                .append(card.getSuit().getName())
                .append(" ");
        }
        return stringBuilder.toString();
    }

    public void getFinalResult(Map<String, List<Integer>> resultMap) {
        System.out.println("\n## 최종 승패");
        resultMap.forEach((name, result) ->
            System.out.printf("%s: %d승 %d무 %d패\n",
                name,
                result.get(0),
                result.get(1),
                result.get(2))
        );
    }

    public void askForMoreCard(NameInfo nameInfo) {
        System.out.println(
            nameInfo.getName() + "는 한장의 카드를 더 받겠습니까?"
       );
    }

    public void printDealerDrawInformation() {
        System.out.println("\n딜러는 16이하라 한장의 카드를 더 받았습니다.\n");
    }
}
