package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResult {

    private static final int SCORE_CRITERIA = 21;

    private final List<Participant> participants;

    private GameResult(List<Participant> participants) {
        this.participants = new ArrayList<>(participants);
        calculateGameResult(this.participants);
    }

    public static GameResult of(Dealer dealer, Players players) {
        List<Participant> participants = new ArrayList<>();
        participants.add(dealer);
        participants.addAll(players.getPlayers());
        return new GameResult(participants);
    }

    private void calculateGameResult(List<Participant> participants) {
        int criteria = calculateCriteria(participants);
        for(Participant participant: participants){
            participant.judgeScore(criteria);
        }
    }

    private int calculateCriteria(List<Participant> participants){
        return participants.stream()
            .mapToInt(Participant::sumCardScore)
            .map(score-> Math.abs(score - SCORE_CRITERIA))
            .min()
            .orElseThrow(() -> {
                throw new IllegalStateException("최대값을 구할 수 없습니다.");
            });
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }
}
