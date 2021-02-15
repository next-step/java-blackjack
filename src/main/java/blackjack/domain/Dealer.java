package blackjack.domain;

public class Dealer extends Player {

    private static final String NAME_CARD = "딜러 카드: ";
    private static final int THRESHOLD_MORE_CARD = 16;

    public Dealer(Deck deck) {
        super(deck);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(NAME_CARD).append(
            getCards().getCardList().get(0).toString()
        ).toString();
    }

    public Boolean addCardUnderScore() {
        calculateScore();
        if (getScore().getValue() <= THRESHOLD_MORE_CARD) {
            addCard(deck.popCard());
            return true;
        }
        return false;
    }
}