package blackjack.service;

import blackjack.domain.Participant;
import java.util.List;

public class WinnerJudgement {

    public List<Participant> judgementWInner(List<Participant> participants) {
        int max = participants.stream()
            .mapToInt(participant -> participant.sumCardScore())
            .max()
            .orElseThrow(() -> {
                throw new IllegalStateException("최대값을 구할 수 없습니다.");
            });

        return null;
    }
}
