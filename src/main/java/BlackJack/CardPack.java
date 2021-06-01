package BlackJack;

import java.util.List;

public class CardPack {
    private List<Card> cards;

    public CardPack(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }
}
