package blackjack.domain.gamer;

import blackjack.domain.card.Denomination;
import blackjack.domain.card.Card;
import blackjack.domain.matchInfo.MatchResult;
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

    public MatchResult getMatchResult(Player player, Dealer dealer) {
        return MatchResult.calcMatchResult(player, dealer);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int calcScore(Player player) {
        int score = player.getCards().stream()
            .map(Card::getDenomination)
            .mapToInt(Denomination::getValue)
            .sum();

        long aceCount = player.getCards().stream().filter(card -> card.getDenomination().isAce()).count();
        for(int i = 0; i < aceCount; i++) {
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

    public boolean isBlackJack(Player player) {
        return calcScore(player) == THRESHOLD;
    }

    public boolean isBust(Player player) {
        return calcScore(player) > THRESHOLD;
    }

    @Override
    public String getName() {
        return name;
    }
}
