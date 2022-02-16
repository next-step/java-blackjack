package blackjack.domain.Card.MatchInfo;

import blackjack.domain.Card.Player;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchResultBoard {

    private final Map<Player, MatchResult> matchResultMap;

    public MatchResultBoard(Map<Player, MatchResult> matchResultMap) {
        this.matchResultMap = matchResultMap;
    }

    public List<PlayerMatchScoreInfo> getPlayersMatchScoreInfo() {
        return matchResultMap
            .entrySet()
            .stream()
            .map(map ->
                new PlayerMatchScoreInfo(
                    map.getKey().getName(),
                    map.getValue().getName()
                ))
            .collect(Collectors.toList());
    }

    public DealerMatchScoreInfo getDealerMatchScoreInfo() {
        return new DealerMatchScoreInfo(
            matchResultMap
                .values()
                .stream()
                .map(MatchResult::oppositeMatchScore)
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(map -> map.getValue() + map.getKey().getName())
                .collect(Collectors.toList())
        );
    }
}
