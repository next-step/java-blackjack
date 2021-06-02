package blackjack.controller;

import blackjack.model.*;
import blackjack.view.Input;

import java.util.Arrays;
import java.util.List;


public class BlackJackController {
    private static final String SPLIT_SEPARATOR = ",";
    private static final int STARTING_CARD_COUNT = 2;

    public void blankJackStart() {
        Player dealer = new Dealer();
        initPlayer(dealer);

        List<String> userNames = Arrays.asList(Input.inputNames().split(SPLIT_SEPARATOR));
        Users users = new Users(userNames);
        initUsers(users.getUser());
    }

    private void initUsers(List<User> users) {
        for (User user : users) {
            initPlayer(user);
        }
    }

    private void initPlayer(Player player) {
        CardGenerator cardGenerator = new CardGenerator();
        player.addSeveralCard(cardGenerator.getSeveralCard(STARTING_CARD_COUNT));
    }
}
