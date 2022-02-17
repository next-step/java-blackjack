package blackjack.domain.matchInfo;

import blackjack.domain.gamer.Dealer;
import blackjack.domain.gamer.Player;
import java.util.Arrays;

public enum MatchResult {
    WIN(1, "승"),
    DRAW(0, "무"),
    LOSE(-1, "패");

    private static final String WRONG_MATCH_SCORE_KEY_ERR_MSG = "잘못된 매치 결과 키값입니다.";
    private static final String UNREACHABLE_POINT_ERR_MSG = "예기치 않은 오류입니다.";

    private final int key;
    private final String name;

    MatchResult(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static MatchResult of(final int value) {
        return Arrays.stream(MatchResult.values())
            .filter(result -> result.key == value)
            .findFirst()
            .orElseThrow(() -> new RuntimeException(WRONG_MATCH_SCORE_KEY_ERR_MSG));
    }

    public static MatchResult calcMatchResult(Player player, Dealer dealer) {
        if (player.isBust(player)) return LOSE;
        if (dealer.isBust(dealer)) return WIN;

        if (player.isBlackJack(player) && dealer.isBlackJack(dealer)) return DRAW;
        if (player.isBlackJack(player)) return WIN;
        if (dealer.isBlackJack(dealer)) return LOSE;

        if (player.calcScore(player) == dealer.calcScore(dealer)) return DRAW;
        if (player.calcScore(player) > dealer.calcScore(dealer)) return WIN;
        if (player.calcScore(player) < dealer.calcScore(dealer)) return LOSE;

        throw new RuntimeException(UNREACHABLE_POINT_ERR_MSG);
    }

    public MatchResult oppositeMatchResult() {
        return MatchResult.of(-key);
    }
}
