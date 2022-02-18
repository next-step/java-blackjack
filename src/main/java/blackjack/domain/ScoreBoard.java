package blackjack.domain;

import blackjack.dto.MatchInfo;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScoreBoard {

    private final static String DELIMITER = " ";
    private final static String SCORE_RESULT_FORMAT = "%s%s";

    private final Map<Player, Score> scoreMap;

    public ScoreBoard(final Map<Player, Score> scoreMap) {
        this.scoreMap = scoreMap;
    }

    public MatchInfo dealerMatches(final Dealer dealer) {
        final Map<Score, Long> countingMap = scoreMap.values().stream()
            .map(Score::oppositeScore)
            .collect(Collectors.groupingBy(o -> o, Collectors.counting()));

        return new MatchInfo(dealer.userName, dealerResultFormat(countingMap));
    }

    public List<MatchInfo> playerMatches() {
        return scoreMap.entrySet().stream()
            .map(map -> new MatchInfo(map.getKey().userName, map.getValue().getName()))
            .collect(Collectors.toList());
    }

    private String dealerResultFormat(final Map<Score, Long> countingMap) {
        return countingMap.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .map(map -> String.format(SCORE_RESULT_FORMAT, map.getValue(), map.getKey().getName()))
            .collect(Collectors.joining(DELIMITER));
    }

}
