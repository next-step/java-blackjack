package blackjack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Gamers {
    private static final int FIRST_DRAW_CARD_COUNT = 2;
    private final Dealer dealer;
    private final List<User> users;


    public Gamers() {
        dealer = new Dealer("dealer");
        users = new ArrayList<>();
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Player> getPlayers(){
        List<Player> players = new ArrayList<>();
        players.add(dealer);
        players.addAll(users);
        return players;
    }

    public void addUsers(Map<String,Integer> nameAndMoneys){
        nameAndMoneys.forEach((name,money) -> users.add(User.of(name,Money.of(money))));
    }

    public void initGamerCardHand(BlackJackCard blackJackCard){
        drawCardAsCount(dealer, blackJackCard);
        users.forEach(user -> drawCardAsCount(user, blackJackCard));
    }

    private void drawCardAsCount(Player player, BlackJackCard blackJackCard) {
        for (int i = 0; i < FIRST_DRAW_CARD_COUNT; ++i){
            player.drawCard(blackJackCard.pickOneCard());
        }
    }

    public void calculateResult(){
        users.forEach(user -> {
            if(isDealerWin(user) || isBusted(user)){
                dealer.incrementWinningCount();
                user.setWin(false);
                return;
            }
            dealer.incrementLosingCount();
            user.setWin(true);
        });
    }

    public void caculateRevenue() {
        users.forEach(user -> checkStateAndRevenue(user));
    }

    private void checkStateAndRevenue(Player player) {
        boolean isBlackjackDealer = isBlackjack(dealer);
        boolean isBustedDealer = isBusted(dealer);
        if (isBustedDealer) {
            return;
        }
        if (isBlackjackOnlyPlayer(player, isBlackjackDealer)) {
            return;
        }
        if (isBustedOnlyPlayer(player)) {
            return;
        }
        dealer.money.subtractAsRevenue(player.money.getMoney());
        player.money.setRevenueToMoney();

    }

    private boolean isBustedOnlyPlayer(Player player) {
        if (isBusted(player) || isDealerWin(player)) {
            dealer.money.addMoney(player.money.getMoney());
            player.money.subtractMoney();
            return true;
        }
        return false;
    }

    private boolean isBlackjackOnlyPlayer(Player player, boolean isBlackjackDealer) {
        if (isBlackjack(player) && !isBlackjackDealer) {
            dealer.money.subtractAsRevenue(player.money.getMoney());
            player.money.setRevenueToMoney();
            return true;
        }
        return false;
    }

    private boolean isBusted(Player player) {
        return player.getCardHandScore() > CardBundle.BLACK_JACK;
    }

    private boolean isBlackjack(Player player) {
        return player.getCardHandScore() == CardBundle.BLACK_JACK && player.getCardBundleSize() == FIRST_DRAW_CARD_COUNT;
    }
    private boolean isDealerWin(Player player) {
        return dealer.getCardHandScore() <= CardBundle.BLACK_JACK && dealer.getCardHandScore() >= player.getCardHandScore();
    }
}
