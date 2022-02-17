package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participants {

    private final List<Participant> participants;
    private final Deck deck;
    private int targetIndex;

    private Participants(List<Participant> participants) {
        this.deck = Deck.create();
        this.participants = new ArrayList<>(participants);
        this.targetIndex = 0;
    }

    public static Participants from(Players players, Dealer dealer) {
        List<Participant> participants = new ArrayList<>(players.getPlayers());
        participants.add(dealer);
        return new Participants(participants);
    }

    public void drawCardMultiple(int number) {
        for (Participant participant : participants) {
            participant.drawCardMultiple(deck, number);
        }
    }

    public void drawCard(Participant participant) {

    }

    public void judgeScore(){
        int maxScore = calculateMaxScore();
        for(Participant participant : participants){
            participant.judgeScore(maxScore);
        }
    }

    private int calculateMaxScore(){
        return participants.stream()
            .mapToInt(participant -> participant.sumCardScore())
            .max()
            .orElseThrow(() -> {
                throw new IllegalStateException("최대값을 구할 수 없습니다.");
            });
    }

    public boolean isNext(){
        return targetIndex > participants.size();
    }

    public void nextTarget(){
        if(!isNext())
            return;
        targetIndex ++;
    }

    public Participant getTarget() {
        return participants.get(targetIndex);
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }
}
