package blackjack.controller;

import blackjack.model.Participant;
import blackjack.model.Participants;
import blackjack.model.Stadium;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void start() {
        String names = inputView.inputName();
        Participants participants = createParticipants(names);

        participants.initialCardSetting();
//        Stadium stadium = new Stadium(participants);
//        stadium.playCardGame();
    }

    private Participants createParticipants(String names) {
        List<Participant> participants = new ArrayList<>();
        participants.add(new Participant("딜러"));
        for (String name : names.split(",")) {
            participants.add(new Participant(name));
        }
        return new Participants(participants);
    }
}
