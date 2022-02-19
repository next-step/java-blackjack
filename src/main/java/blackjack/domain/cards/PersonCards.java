package blackjack.domain.cards;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import java.util.ArrayList;
import java.util.List;

public abstract class PersonCards implements Cards {

    protected List<Card> cards;
    protected int sum;

    public PersonCards(List<Card> cards) {
        initCard(cards);
        initSum();
    }

    @Override
    public void addCard(Card card) {
        cards.add(card);
        updateSumByDenomination(card.getDenomination());
    }

    @Override
    public int getSumOfCards() {
        return sum;
    }

    private void updateSumByDenomination(Denomination denomination) {
        if (canAddBiggerValueByAce(denomination)) {
            sum += 11;
            return;
        }
        sum += denomination.getValue();
    }

    private boolean canAddBiggerValueByAce(Denomination denomination) {
        return denomination.equals(Denomination.ACE) && sum <= 10;
    }

    private void initCard(List<Card> cards) {
        this.cards = new ArrayList<>();
        this.cards.addAll(cards);
    }

    private void initSum() {
        this.cards.forEach(card -> updateSumByDenomination(card.getDenomination()));
    }

    abstract boolean canReceiveMoreCard();

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }
}
