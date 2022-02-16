package blackjack.domain.Card.MatchInfo;

import java.util.Objects;

public class PlayerMatchScoreInfo {
    private final String name;
    private final String matchScore;

    public PlayerMatchScoreInfo(String name, String matchScore) {
        this.name = name;
        this.matchScore = matchScore;
    }

    public String getName() {
        return name;
    }

    public String getMatchScore() {
        return matchScore;
    }

    @Override
    public String toString() {
        return "PlayerMatchScoreInfo{" +
            "name='" + name + '\'' +
            ", matchScore='" + matchScore + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerMatchScoreInfo that = (PlayerMatchScoreInfo) o;
        return Objects.equals(name, that.name) && Objects.equals(matchScore,
            that.matchScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, matchScore);
    }

}
