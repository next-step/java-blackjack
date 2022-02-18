package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Participants;
import blackjack.domain.Players;
import blackjack.view.InputView;
import blackjack.view.PrintView;
import java.util.List;

public class GameController {

    public static void start() {
        List<String> name = InputView.inputNames();

        Players players = Players.from(name);
        Dealer dealer = new Dealer("딜러");
        Participants participants = Participants.from(players, dealer);

        participants.drawCardMultiple(2);
        PrintView.printFirstDrawCards(participants);

        participants.drawCardContinue(1);
        PrintView.printGameResult(participants);

        participants.judgeScore();
        PrintView.printWinLose(participants);
    }
}
