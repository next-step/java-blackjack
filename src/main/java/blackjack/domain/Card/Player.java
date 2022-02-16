package blackjack.domain.Card;

import java.util.List;

public class Player extends Gamer {
    private static final int TEN = 10;
    private static final int THRESHOLD = 21;

    private List<Card> cards;
    private final String name;

    public Player(String name) {
        this.name = name;
        cards = initSetting();
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getPlayerCardSum(Player player) {
        int score = player.getCards().stream()
            .map(Card::getDenomination)
            .mapToInt(Denomination::getValue)
            .sum();

        long aceCount = player.getCards().stream().filter(card -> card.getDenomination().isAce()).count();
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

    @Override
    public String getName() {
        return name;
    }
}
