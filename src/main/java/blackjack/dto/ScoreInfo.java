package blackjack.dto;

import java.util.List;

public class ScoreInfo {

    private final String name;
    private final List<String> cardNames;
    private final int score;

    public ScoreInfo(String name, List<String> cardNames, int score) {
        this.name = name;
        this.cardNames = cardNames;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public List<String> getCardNames() {
        return cardNames;
    }

    public int getScore() {
        return score;
    }
}
