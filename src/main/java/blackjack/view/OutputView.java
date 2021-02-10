package blackjack.view;

import blackjack.dto.CardBunchInfo;
import blackjack.dto.CardInfo;
import blackjack.dto.NameInfo;
import blackjack.dto.PersonInfo;


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

    public void askForMoreCard(NameInfo nameInfo) {
        System.out.println(
            nameInfo.getName() + "는 한장의 카드를 더 받겠습니까?"
       );
    }
}
