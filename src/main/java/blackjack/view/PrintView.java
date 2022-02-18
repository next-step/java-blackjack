package blackjack.view;

import blackjack.domain.Participant;
import blackjack.domain.Participants;
import java.util.List;

public class PrintView {

    public static void printFirstDrawCards(Participants participants) {
        System.out.println(participants.participantsNames() + "에게 2장의 카드를 나누었습니다.");

        List<Participant> participantList = participants.getParticipants();
        participantList.stream()
            .forEach(participant -> System.out.println(participant.holdingInfo()));
    }

    public static void printGameResult(Participants participants) {
        List<Participant> participantList = participants.getParticipants();
        participantList.stream()
            .forEach(participant -> System.out.println(
                participant.holdingInfo() + "- 결과 : " + participant.sumCardScore()));
    }

    public static void printWinLose(Participants participants) {
        List<Participant> participantList = participants.getParticipants();
        participantList.stream()
            .forEach(participant -> System.out.println(participant.scoreResult()));
    }
}
