package blackjack.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player implements GameParticipant {
    private static final int BLACKJACK = 21;
    private static final int ACE_BONUS= 10;
    private final String name;
    private List<Card> cards = new ArrayList<>();

    public Player(final String name) {
        validateNonEmptyName(name);
        this.name = name;
    }

    private void validateNonEmptyName(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름으로 사용할 수 없습니다.");
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Card> getCards() {
        return this.cards;
    }

    @Override
    public void hit(Card card) {
        this.cards.add(card);
    }

    @Override
    public List<Card> getCardsBeforeGameStart() {
        return Arrays.asList(cards.get(0), cards.get(1));
    }

    @Override
    public int getResult() {
        int score = 0;
        boolean hasAce = false;
        for (Card card : cards) {
            int cardNumber = card.getDenomination().getNumber();
            score += cardNumber;
            hasAce = hasAce || checkAce(cardNumber);
        }
        if (hasAce && score + ACE_BONUS <= BLACKJACK) {
            score += ACE_BONUS;
        }
        return score;
    }

    @Override
    public boolean checkAce(int cardNumber) {
        return cardNumber == 1;
    }
}
