package blackjack.dto;

import java.util.List;

public class CardInfo {

    private final String personName;
    private final List<String> cardNames;

    public CardInfo(String personName, List<String> cardNames) {
        this.personName = personName;
        this.cardNames = cardNames;
    }

    public String getPersonName() {
        return personName;
    }

    public List<String> getCardNames() {
        return cardNames;
    }
}
