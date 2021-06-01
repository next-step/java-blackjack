package blackjack.service;

import java.util.ArrayList;
import java.util.List;

public abstract class Player{
    String name;
    List<Card> cards = new ArrayList<>();

    abstract void addDraw();


    public void startDraw(CardDeck cardDeck){

        draw(cardDeck);
        draw(cardDeck);

    };

    public void draw(CardDeck cardDeck){
        Card card = cardDeck.getCard();
        cards.add(card);
    }
}
