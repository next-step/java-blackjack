package blackjack.dto;

import java.util.List;
import java.util.Objects;

public class CardBunchInfo {

    private final List<CardInfo> cardsInfo;

    public CardBunchInfo(List<CardInfo> cardsInfo) {
        this.cardsInfo = cardsInfo;
    }

    public List<CardInfo> getCardsInfo() {
        return cardsInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardBunchInfo that = (CardBunchInfo) o;
        return Objects.equals(cardsInfo, that.cardsInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardsInfo);
    }
}
