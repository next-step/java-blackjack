package blackjack.dto;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ScoreInfo scoreInfo = (ScoreInfo) o;
        return score == scoreInfo.score && Objects.equals(name, scoreInfo.name)
            && Objects.equals(cardNames, scoreInfo.cardNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cardNames, score);
    }
}
