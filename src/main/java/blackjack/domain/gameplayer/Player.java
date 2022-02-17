package blackjack.domain.gameplayer;

import java.util.List;
import java.util.NoSuchElementException;

public class Player extends GamePlayer {

    private static final String WIN = "승";
    private static final String LOSE = "패";

    public Player(Name name) {
        super(name);
    }

    @Override
    public boolean isLowerThanBound() {
        return isContinue();
    }

    @Override
    public String getGameResult(GamePlayers gamePlayers) {
        List<GamePlayer> allPlayers = gamePlayers.getAllPlayers();
        int winnerScore = allPlayers.stream()
            .filter(GamePlayer::isContinue)
            .map(GamePlayer::getScore)
            .max(Integer::compareTo)
            .orElseThrow(NoSuchElementException::new);

        if (this.getScore() == winnerScore && isContinue()){
            return WIN;
        }
        return LOSE;
    }
}
