package blackjack.domain;

import blackjack.dto.MatchInfo;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScoreBoard {

    private final Map<Player, Score> scoreMap;

    public ScoreBoard(Map<Player, Score> scoreMap) {
        this.scoreMap = scoreMap;
    }

    public MatchInfo getDealerMatchInfo(Dealer dealer) {
        return new MatchInfo(
            dealer.userName,
            scoreMap.values().stream()
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(map -> map.getValue() + map.getKey().getName())
                .collect(Collectors.joining(" "))
        );
    }

    public List<MatchInfo> getPlayersMatchInfo() {
        return scoreMap.entrySet().stream()
            .map(map -> new MatchInfo(map.getKey().userName, map.getValue().getName()))
            .collect(Collectors.toList());
    }

}
