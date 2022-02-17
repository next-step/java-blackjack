package blackjack.domain.matchInfo;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DealerMatchResultInfo {
    private final List<String> matchScores;

    public DealerMatchResultInfo(final List<String> matchScores) {
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
        DealerMatchResultInfo that = (DealerMatchResultInfo) o;
        return Objects.equals(matchScores, that.matchScores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchScores);
    }

    public List<String> getMatchResult() {
        return Collections.unmodifiableList(matchScores);
    }

}
