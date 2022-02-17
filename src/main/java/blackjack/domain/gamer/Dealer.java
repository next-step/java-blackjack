package blackjack.domain.gamer;

import blackjack.domain.card.Denomination;
import blackjack.domain.card.Card;
import java.util.List;

public class Dealer extends Gamer{
    private static final int TEN = 10;
    private static final int THRESHOLD = 21;

    private List<Card> cards;

    public Dealer() {
        this.cards = initSetting();
    }

    public int calcScore(Dealer dealer) {
        int score = dealer.getCards().stream()
            .map(Card::getDenomination)
            .mapToInt(Denomination::getValue)
            .sum();

        long aceCount = dealer.getCards().stream().filter(card -> card.getDenomination().isAce()).count();
        for(int i = 0; i< aceCount; i++) {
            score = adjustScore(score);
        }
        return score;
    }

    private int adjustScore(int score) {
        if(score + TEN <= THRESHOLD) {
            score += TEN;
        }
        return score;
    }

    public boolean isBlackJack(Dealer dealer) {
        return calcScore(dealer) == THRESHOLD;
    }

    public boolean isBust(Dealer dealer) {
        return calcScore(dealer) > THRESHOLD;
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String getName() {
        return "딜러";
    }
}
