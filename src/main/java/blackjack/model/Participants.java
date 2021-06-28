package blackjack.model;

import java.util.List;

public class Participants {
    private static final int INITIAL_CARD_NUMBER = 2;
    private List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public void initialCardSetting() {
        for(Participant participant : participants) {
            for (int i = 0; i < INITIAL_CARD_NUMBER; i++) {
                participant.drawCard();
            }
        }
    }
}
