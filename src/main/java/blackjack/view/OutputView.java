package blackjack.view;

import blackjack.domain.participant.Participant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String DELIMITER = ", ";
    private static final int NUMBER_OF_INIT_HANDS = 2;
    private static final String DISTRIBUTE_MESSAGE_FORMAT = "%s에게 카드를 %d장씩 분배하였습니다.%n";
    private static final String PARTICIPANT_STATUS_FORMAT = "%s카드: %s%n";
    private static final String PARTICIPANT_FINAL_STATUS_FORMAT = "%s카드: %s - 결과: %d%n";
    private static final String WINNING_OR_LOSE_HEADER_MESSAGE = "## 최종 승패\n";
    private static final String WINNING_OR_LOSE_FORMAT = "%s: %s%n";
    private static final String DEALER_DRAW_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.\n";

    private OutputView() {
    }

    public static void printStartStatus(final List<Participant> participants) {
        printDealResult(participants);
        printParticipantsStatus(participants);
    }

    private static void printDealResult(final List<Participant> participants) {
        System.out.printf(DISTRIBUTE_MESSAGE_FORMAT, getNames(participants), NUMBER_OF_INIT_HANDS);
    }

    private static String getNames(final List<Participant> participants) {
        return participants.stream()
            .map(Participant::getName)
            .collect(Collectors.joining(DELIMITER));
    }

    public static void printParticipantsStatus(final List<Participant> participants) {
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

    public static void printGameResult(List<Participant> participants, Map<String, String> result) {
        printFinalStatus(participants);
        printWinOrLose(result);
    }

    private static void printFinalStatus(List<Participant> participants) {
        StringBuilder status = new StringBuilder();
        participants.forEach(participant ->
            status.append(String.format(
                PARTICIPANT_FINAL_STATUS_FORMAT, participant.getName(), getCardNames(participant), participant.getScore())));

        System.out.println(status);
    }

    private static void printWinOrLose(Map<String, String> results) {
        StringBuilder winOrLose = new StringBuilder(WINNING_OR_LOSE_HEADER_MESSAGE);

        results.forEach((name, result)->
            winOrLose.append(String.format(
                WINNING_OR_LOSE_FORMAT, name, result)));

        System.out.println(winOrLose);
    }

    public static void printDealerDrawMessage() {
        System.out.println(DEALER_DRAW_MESSAGE);
    }
}
