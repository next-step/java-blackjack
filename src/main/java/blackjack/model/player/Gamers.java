package blackjack.model.player;

import blackjack.model.card.BlackJackCard;
import blackjack.model.card.CardBundle;

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
        addUsers(Arrays.asList(usersName));
    }

    public void addUsers(List<String> usersName) {
        usersName.forEach(name -> users.add(User.of(name)));
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
        users.forEach(user -> dealerWinOrLose(canDealerWin(user), user));
    }

    private boolean canDealerWin(User user) {
        return (dealer.getCardHandScore() <= CardBundle.BLACK_JACK
                && dealer.getCardHandScore() >= user.getCardHandScore())
                || user.getCardHandScore() > CardBundle.BLACK_JACK;
    }

    private void dealerWinOrLose(boolean win, User enemy) {
        if(win){
            dealer.increaseWinningCount();
            enemy.setWin(false);
            return;
        }
        dealer.increaseLosingCount();
        enemy.setWin(true);
    }
}
