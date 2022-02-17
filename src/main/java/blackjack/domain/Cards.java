package blackjack.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cards {

    private List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public void add(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public boolean sum(){
        return sumScore()>=21;
    }

    public int sumScore() {
        Comparator<Card> comparator = (a, b) -> b.getCardNumber().getScore() - a.getCardNumber()
            .getScore();

        List<Card> newCards = new ArrayList<>(cards);
        newCards.sort(comparator);

        return newCards.stream()
            .mapToInt(card -> card.getCardNumber().getScore())
            .reduce(0, (a, b) -> a + getScoreToSum(a, b));
    }


    public static int getScoreToSum(int score1, int score2) {
        if ((score2 == CardNumber.ACE.getScore()) && (score1 + CardNumber.ACE.getScore() > 21)) {
            return 1;
        }
        return score2;
    }

    public int getTotalScore() {
        return cards.stream().mapToInt(card -> card.getCardNumber().getScore()).sum();
    }
}