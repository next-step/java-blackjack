package blackjack.view;

import blackjack.domain.participant.Participant;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String DELIMITER = ", ";
    private static final int NUMBER_OF_INIT_HANDS = 2;
    private static final String DISTRIBUTE_MESSAGE_FORMAT = "%s에게 카드를 %d장씩 분배하였습니다.%n";
    private static final String PARTICIPANT_STATUS_FORMAT = "%s카드: %s%n";

    private OutputView() {
    }

    public static void printInitProgress(final List<Participant> participants) {
        printDistributeInfo(participants);
        printParticipantsStatus(participants);
    }

    private static void printDistributeInfo(final List<Participant> participants) {
        System.out.printf(DISTRIBUTE_MESSAGE_FORMAT, getNames(participants), NUMBER_OF_INIT_HANDS);
    }

    private static String getNames(final List<Participant> participants) {
        return participants.stream()
            .map(Participant::getName)
            .collect(Collectors.joining(DELIMITER));
    }

    private static void printParticipantsStatus(final List<Participant> participants) {
        StringBuilder status = new StringBuilder();
        participants.forEach(participant ->
            status.append(String.format(
                PARTICIPANT_STATUS_FORMAT, participant.getName(), getCardNames(participant))));

        System.out.println(status);
    }

    private static String getCardNames(final Participant participant) {
        return participant.getCardNames().stream()
            .collect(Collectors.joining(DELIMITER));
    }
    public static void printDealerDraw() {
        System.out.println(DEALER_DRAW_MESSAGE);
    }
}
