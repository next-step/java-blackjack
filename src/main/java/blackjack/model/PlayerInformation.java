package blackjack.model;

import java.util.List;

public class PlayerInformation {
    private final String name;
    private final BunchOfCard bunchOfCard;

    public PlayerInformation(String name, BunchOfCard bunchOfCard) {
        this.name = name;
        this.bunchOfCard = bunchOfCard;
    }

    public void addCard(Card card) {
        this.bunchOfCard.addCard(card);
    }

    public int getCardValueSum() {
        return bunchOfCard.getCardValueSum();
    }

    public List<String> getCardNames() {
        return bunchOfCard.getCardNames();
    }

    public String getName() {
        return name;
    }
}
