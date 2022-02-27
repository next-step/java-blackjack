package blackjack.dto;

import java.util.List;
import java.util.Objects;

public class CardInfo {

    private final String personName;
    private final List<String> cardNames;

    public CardInfo(final String personName, final List<String> cardNames) {
        this.personName = personName;
        this.cardNames = cardNames;
    }

    public String getPersonName() {
        return personName;
    }

    public List<String> getCardNames() {
        return cardNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CardInfo cardInfo = (CardInfo) o;
        return Objects.equals(personName, cardInfo.personName) && Objects.equals(
            cardNames, cardInfo.cardNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personName, cardNames);
    }
}
