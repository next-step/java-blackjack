package blackjack.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gamers {
    private static final int FIRST_DRAW_CARD_COUNT = 2;
    private final Dealer dealer;
    private final List<User> users;

    public Gamers() {
        dealer = Dealer.of("dealer");
        users = new ArrayList<>();
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(dealer);
        players.addAll(users);
        return players;
    }

    public void addUsers(String[] usersName) {
        Arrays.stream(usersName).forEach(name -> users.add(User.of(name)));
    }

    public void initGamerCardHand(BlackJackCard blackJackCard) {
        drawCardAsCount(dealer, blackJackCard);
        users.forEach(user -> drawCardAsCount(user, blackJackCard));
    }

    private void drawCardAsCount(Player player, BlackJackCard blackJackCard) {
        for (int i = 0; i < FIRST_DRAW_CARD_COUNT; ++i) {
            player.drawCard(blackJackCard.pickOneCard());
        }
    }

    public void calculateResult() {

        users.forEach(user -> {
            if (dealerResultValidation(user)
                    || user.getCardHandScore() > CardBundle.BLACK_JACK) {
                dealer.increaseWinningCount();
                user.setWin(false);
                return;
            }
            dealer.increaseLosingCount();
            user.setWin(true);
        });
    }

    private boolean dealerResultValidation(User user) {
        return dealer.getCardHandScore() <= CardBundle.BLACK_JACK && dealer.getCardHandScore() >= user.getCardHandScore();
    }
}
