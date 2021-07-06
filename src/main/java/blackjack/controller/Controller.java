package blackjack.controller;

import blackjack.model.*;
import blackjack.view.InputView;
import com.sun.org.apache.xerces.internal.impl.dv.util.ByteListImpl;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private InputView inputView = new InputView();

    public void start() {
        String names = inputView.inputName();
        Dealer dealer = new Dealer();
        Players players = createPlayers(names);

        participants.initialCardSetting();
        participants.additionalCardSetting(inputView);
//        Stadium stadium = new Stadium(participants);
//        stadium.playCardGame();
    }

    private Players createPlayers(String names) {
        List<Player> players = new ArrayList<>();
        for (String name : names.split(",")) {
            players.add(new Player(name));
        }
        return new Players(players);
    }
}
