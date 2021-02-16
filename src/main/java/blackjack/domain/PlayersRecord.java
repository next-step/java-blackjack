package blackjack.domain;

import blackjack.dto.PlayerRecordView;

import java.util.ArrayList;
import java.util.List;

public class PlayersRecord extends RecordRule {
    private final Dealer dealer;
    private final List<Player> players;
    private final List<PlayerRecordView> playerRecordViews = new ArrayList<>();

    public PlayersRecord(final Dealer dealer, final List<Player> players) {
        this.dealer = dealer;
        this.players = players;
        createPlayerRecordViews();
    }

    private void createPlayerRecordViews() {
        int dealerScore = dealer.getResult();
        for (final Player player : players) {
            int playerScore = player.getResult();
            String result = winOrLose(dealerScore, playerScore);
            playerRecordViews.add(new PlayerRecordView(player.getName(), result));
        }
    }

    public String winOrLose(final int dealerScore, final int playerScore) {
        if (playerWin(dealerScore, playerScore)) {
            return "패";
        }
        if (playerDraw(dealerScore, playerScore)) {
            return "무";
        }
        return "승";
    }

    public List<PlayerRecordView> getPlayerRecordViews() {
        return playerRecordViews;
    }
}
