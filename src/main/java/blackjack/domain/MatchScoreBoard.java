package blackjack.domain;

import blackjack.dto.DealerScoreInfo;
import blackjack.dto.PlayerScoreInfo;
import blackjack.dto.PlayersScoreInfo;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class MatchScoreBoard {
    private Map<Player, MatchScore> matchScoreMap;

    public MatchScoreBoard() {
        matchScoreMap = new HashMap<>();
    }

    public PlayersScoreInfo getPlayersScoreInfo() {
        return new PlayersScoreInfo(
            matchScoreMap
                .entrySet()
                .stream()
                .map(map -> new PlayerScoreInfo(
                    map.getKey().getNameInfo(),
                    map.getValue().getName()
                ))
                .collect(Collectors.toSet())
        );
    }

    public DealerScoreInfo getDealerScoreInfo() {
        return new DealerScoreInfo(
            matchScoreMap
                .entrySet()
                .stream()
                .map(map -> map.getValue().oppositeMatchScore())
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(map -> map.getValue() + map.getKey().getName())
                .collect(Collectors.toList())
        );
    }
}
