package blackjack.ui;

import blackjack.domain.Dealer;
import blackjack.domain.GameResult;
import blackjack.domain.Participant;
import blackjack.domain.Player;
import blackjack.domain.Players;
import java.util.stream.Collectors;

public class BlackjackOutput {

    private static final String COMMA = ", ";
    private static final String DEALER_NAME = "딜러와 ";
    private static final String ENTER = "\n";

    public static void printDrawCard(Players players) {
        String playerName = players.getPlayers().stream()
            .map(Player::getName)
            .collect(Collectors.joining(COMMA));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
            .append(DEALER_NAME)
            .append(playerName)
            .append("에게 2장을 나누었습니다.");
        System.out.println(stringBuilder);
    }

    public static void printAllCard(Players players, Dealer dealer){
        players.getPlayers().stream()
            .forEach(BlackjackOutput::printParticipantCard);
        printParticipantCard(dealer);
        System.out.println(ENTER);
    }

    public static void printParticipantCard(Participant player) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
            .append(player.getName())
            .append("카드: ")
            .append(getCardStatus(player));
        System.out.println(stringBuilder);
    }

    private static String getCardStatus(Participant player){
        return player
            .getCards()
            .getCards()
            .stream()
            .map(card -> card.getNumber() + card.getCardTypeName())
            .collect(Collectors.joining(COMMA));
    }

    public static void printFinalResult(GameResult gameResult){
        System.out.println("## 최종승패");
        String result = gameResult.getParticipants().stream()
            .map(participant -> participant.getName()+": "+participant.getWinScore()+"승 "+participant.getLoseScore()+"패")
            .collect(Collectors.joining(ENTER));
        System.out.println(result);
    }
}
