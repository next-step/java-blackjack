package blackjack.domain.Card.MatchInfo;

import java.util.List;
import java.util.Objects;

public class DealerMatchScoreInfo {
    private final List<String> matchScores;

    public DealerMatchScoreInfo(List<String> matchScores) {
        this.matchScores = matchScores;
    }

    @Override
    public String toString() {
        return "DealerMatchScoreInfo{" +
            "matchScores=" + matchScores +
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
        DealerMatchScoreInfo that = (DealerMatchScoreInfo) o;
        return Objects.equals(matchScores, that.matchScores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchScores);
    }

    public List<String> getMatchScores() {
        return matchScores;
    }


}
