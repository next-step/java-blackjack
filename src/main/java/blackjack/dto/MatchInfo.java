package blackjack.dto;

import java.util.Objects;

public class MatchInfo {

    private final String name;
    private final String matches;

    public MatchInfo(final String name, final String matches) {
        this.name = name;
        this.matches = matches;
    }

    public String getName() {
        return name;
    }

    public String getMatches() {
        return matches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MatchInfo matchInfo = (MatchInfo) o;
        return Objects.equals(name, matchInfo.name) && Objects.equals(matches,
            matchInfo.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, matches);
    }
}
