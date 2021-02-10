package blackjack.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class PlayersScoreInfo {
    private final Set<PlayerScoreInfo> playersScoreInfo;
}
