package blackjack.dto;

public class MatchInfo {
    private final String name;
    private final String matches;

    public MatchInfo(String name, String matches) {
        this.name = name;
        this.matches = matches;
    }

    public String getName() {
        return name;
    }

    public String getMatches() {
        return matches;
    }
}
