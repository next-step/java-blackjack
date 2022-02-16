package blackjack.domain;

import blackjack.domain.Card.CardType;
import blackjack.domain.Card.CardValue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Deck {

    private final Deque<Card> deck = new ArrayDeque<>();

    public Deck(List<CardType> cardTypes, List<CardValue> cardValues) {
        for (CardType cardType : cardTypes) {
            for (CardValue cardValue : cardValues) {
                deck.add(new Card(cardType, cardValue));
            }
        }
    }

    public List<Card> drawMultiple(int num) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            cards.add(draw());
        }
        return cards;
    }

    public Card draw() {
        if (deck.size() == 0) {
            throw new IllegalStateException("패가 더이상 존재하지 않습니다.");
        }
        return deck.pop();
    }
}
