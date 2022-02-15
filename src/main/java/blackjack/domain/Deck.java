package blackjack.domain;

import blackjack.domain.Card.CardType;
import blackjack.domain.Card.CardValue;
import java.util.List;
import java.util.Stack;

public class Deck {
    private final Stack<Card> deck = new Stack<>();

    public Deck(List<CardType> cardTypes, List<CardValue> cardValues) {
        for(CardType cardType : cardTypes){
            for(CardValue cardValue : cardValues){
                deck.add(new Card(cardType, cardValue));
            }
        }
    }

    public Card draw() {
        if(deck.size() == 0) {
            throw new IllegalStateException("패가 더이상 존재하지 않습니다.");
        }
        return deck.pop();
    }
}
