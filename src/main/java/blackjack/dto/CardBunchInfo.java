package blackjack.dto;

import java.util.List;

public class CardBunchInfo {
    private final List<CardInfo> cardsInfo;

    public CardBunchInfo(List<CardInfo> cardsInfo) {
        this.cardsInfo = cardsInfo;
    }

    public List<CardInfo> getCardsInfo() {
        return cardsInfo;
    }
}
