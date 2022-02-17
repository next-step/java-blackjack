package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Participant> winners;

    private Winners(List<Participant> participants) {
        List<Participant> winners = filterWinner(participants);
        this.winners = new ArrayList<>(participants);
    }

    public static Winners of(Dealer dealer, Participants players) {
        List<Participant> participants = new ArrayList<>();
        participants.add(dealer);
        participants.addAll(players.getParticipants());
        return new Winners(participants);
    }

    private List<Participant> filterWinner(List<Participant> participants) {
        final int maxScore = calculateMaxScore(participants);

        return participants.stream()
            .filter(participant -> participant.sumCardScore() == maxScore)
            .collect(Collectors.toList());
    }

    private int calculateMaxScore(List<Participant> participants){
        return participants.stream()
            .mapToInt(participant -> participant.sumCardScore())
            .max()
            .orElseThrow(() -> {
                throw new IllegalStateException("최대값을 구할 수 없습니다.");
            });
    }

    public List<Participant> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
