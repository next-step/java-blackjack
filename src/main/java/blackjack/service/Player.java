package blackjack.service;

import java.util.ArrayList;
import java.util.List;

public abstract class Player{
    String name;
    List<Card> cards = new ArrayList<>();

    abstract void addDraw(CardDeck cardDeck);


    public void startDraw(CardDeck cardDeck){

        draw(cardDeck);
        draw(cardDeck);

    };

    public void draw(CardDeck cardDeck){
        Card card = cardDeck.getCard();
        cards.add(card);
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }
    public Integer getScore() {
        return cards.stream()
                .map(card -> card.getCardNumber().getScore())
                .reduce(0, Integer::sum);
    }
}
