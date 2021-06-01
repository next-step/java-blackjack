package blackjack.service;

import java.util.ArrayList;
import java.util.List;

public class Player{
    String name;
    List<Card> cards = new ArrayList<>();

    public void draw(CardDeck cardDeck){
        Card card = cardDeck.getCard();
        cards.add(card);
    }
}
