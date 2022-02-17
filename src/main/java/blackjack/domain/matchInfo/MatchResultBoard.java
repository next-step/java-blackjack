package blackjack.domain.matchInfo;

import blackjack.domain.gamer.Player;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchResultBoard {

    private final Map<Player, MatchResult> matchResultMap;

    public MatchResultBoard(Map<Player, MatchResult> matchResultMap) {
        this.matchResultMap = matchResultMap;
    }

    public List<PlayerMatchResultInfo> getPlayersMatchResultInfo() {
        return matchResultMap
            .entrySet()
            .stream()
            .map(map ->
                new PlayerMatchResultInfo(
                    map.getKey().getName(),
                    map.getValue().getName()
                ))
            .collect(Collectors.toList());
    }

    public DealerMatchResultInfo getDealerMatchResultInfo() {
        return new DealerMatchResultInfo(
            matchResultMap
                .values()
                .stream()
                .map(MatchResult::oppositeMatchResult)
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(map -> map.getValue() + map.getKey().getName())
                .collect(Collectors.toList())
        );
    }
}
