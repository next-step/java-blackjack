package blackjack.domain;

import blackjack.dto.DealerMatchScoreInfo;
import blackjack.dto.PlayerMatchScoreInfo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchScoreBoard {
    private final Map<Player, MatchScore> matchScoreMap;

    public MatchScoreBoard(Map<Player, MatchScore> matchScoreMap) {
        this.matchScoreMap = matchScoreMap;
    }

    public List<PlayerMatchScoreInfo> getPlayersMatchScoreInfo() {
        return matchScoreMap
            .entrySet()
            .stream()
            .map(map ->
                new PlayerMatchScoreInfo(
                    map.getKey().name,
                    map.getValue().getName()
                ))
            .collect(Collectors.toList());
    }

    public DealerMatchScoreInfo getDealerMatchScoreInfo() {
        return new DealerMatchScoreInfo(
            matchScoreMap
                .values()
                .stream()
                .map(MatchScore::oppositeMatchScore)
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(map -> map.getValue() + map.getKey().getName())
                .collect(Collectors.toList())
        );
    }
}
