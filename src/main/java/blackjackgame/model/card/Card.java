package blackjackgame.model.card;

public class Card {
    private Suit suit;
    private Denomination denomination;

    Card(Suit suit, Denomination denomination){
        this.suit = suit;
        this.denomination = denomination;
    }
}
