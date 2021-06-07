package blackjack.model;

import java.util.List;

public class User implements Player {
    private static final int RECEIVE_CARD_CONDITION = 21;

    private final String name;
    private final BunchOfCard bunchOfCard;

    public User(String name) {
        validateNullInput(name);
        this.name = name;
        this.bunchOfCard = new BunchOfCard();
    }

    private void validateNullInput(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름을 입력하지 않으면 생성할 수 없습니다.");
        }
    }

    @Override
    public void addCard(Card card) {
        this.bunchOfCard.addCard(card);
    }

    @Override
    public void addSeveralCard(List<Card> cards) {
        for (Card card : cards) {
            addCard(card);
        }
    }

    @Override
    public int getCardValueSum() {
        return this.bunchOfCard.getCardValueSum();
    }

    @Override
    public List<String> getCardNames() {
        return bunchOfCard.getCardNames();
    }

    @Override
    public boolean canReceiveCard() {
        return getCardValueSum() < RECEIVE_CARD_CONDITION;
    }

    public String getName() {
        return name;
    }
}
