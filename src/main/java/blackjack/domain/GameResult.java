package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResult {

    private final List<Participant> participants;

    private GameResult(List<Participant> participants) {
        calculateGameResult(participants);
        this.participants = new ArrayList<>(participants);
    }

    public static GameResult of(Dealer dealer, Players players) {
        List<Participant> participants = new ArrayList<>();
        participants.add(dealer);
        participants.addAll(players.getPlayers());
        return new GameResult(participants);
    }

    private void calculateGameResult(List<Participant> participants) {
        int maxScore = calculateMaxScore(participants);
        for(Participant participant: participants){
            participant.judgeScore(maxScore);
        }
    }

    private int calculateMaxScore(List<Participant> participants){
        return participants.stream()
            .mapToInt(Participant::sumCardScore)
            .max()
            .orElseThrow(() -> {
                throw new IllegalStateException("최대값을 구할 수 없습니다.");
            });
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }
}
