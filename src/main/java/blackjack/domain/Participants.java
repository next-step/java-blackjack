package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participants {

    private static final String COMMA = ", ";

    private final List<Participant> participants;
    private final Deck deck;

    private Participants(List<Participant> participants) {
        this.deck = Deck.create();
        this.participants = new ArrayList<>(participants);
    }

    public static Participants from(Players players, Dealer dealer) {
        List<Participant> participants = new ArrayList<>();
        participants.add(dealer);
        participants.addAll(players.getPlayers());
        return new Participants(participants);
    }

    public void drawCardMultiple(int number) {
        for (Participant participant : participants) {
            participant.drawCardMultiple(deck, number);
        }
    }

    public void drawCardContinue(int number) {
        for (Participant participant : participants) {
            participant.drawCardContinue(deck);
        }
    }

    public void judgeScore() {
        int maxScore = calculateMaxScore();
        for (Participant participant : participants) {
            participant.judgeScore(maxScore);
        }
    }

    private int calculateMaxScore() {
        return participants.stream()
            .mapToInt(participant -> participant.sumCardScore())
            .max()
            .orElseThrow(() -> {
                throw new IllegalStateException("최대값을 구할 수 없습니다.");
            });
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public String participantsNames() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < participants.size(); i++) {
            sb.append(participants.get(i).getName());
            if (i != participants.size() - 1) {
                sb.append(COMMA);
            }
        }

        return sb.toString();
    }
}
