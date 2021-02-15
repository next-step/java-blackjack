package blackjack.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cards {

    protected List<Card> cardList;

    public Cards() {
        cardList = new ArrayList<>();
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void addCard(Card card) {
        cardList.add(card);
    }

    public Score getScore() {
        int sum = cardList.stream().mapToInt(card -> card.getDenomination().getScore()).sum(); // 13
        long aceCount = cardList.stream().filter(card -> card.getDenomination().isAce()).count();
        for (int i = 0; i < aceCount; i++) {
            if (sum + 10 <= 21) {
                sum += 10;
            }
        }
        return new Score(sum);
    }

    @Override
    public String toString() {
        return cardList.stream().map(Card::toString).collect(Collectors.joining(", "));
    }
}
