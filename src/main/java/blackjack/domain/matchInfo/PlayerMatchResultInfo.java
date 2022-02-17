package blackjack.domain.matchInfo;

import java.util.Objects;

public class PlayerMatchResultInfo {
    private final String name;
    private final String matchScore;

    public PlayerMatchResultInfo(String name, String matchScore) {
        this.name = name;
        this.matchScore = matchScore;
    }

    public String getName() {
        return name;
    }

    public String getMatchResult() {
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
        PlayerMatchResultInfo that = (PlayerMatchResultInfo) o;
        return Objects.equals(name, that.name) && Objects.equals(matchScore,
            that.matchScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, matchScore);
    }

}
