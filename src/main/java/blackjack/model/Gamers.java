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
        //TODO: 승패 외에 무승부?
        //  단, 카드를 추가로 뽑아 21을 초과할 경우 배팅 금액을 모두 잃게 된다.
        // 처음 두 장의 카드 합이 21일 경우 블랙잭이 되면 베팅 금액의 1.5 배를 딜러에게 받는다. 딜러와 플레이어가 모두 동시에 블랙잭인 경우 플레이어는 베팅한 금액을 돌려받는다.
        users.forEach(user -> {
            if(dealerResultValidation(user)
                    || user.getCardHandScore() > CardBundle.BLACK_JACK){
                dealer.setWinningCount(dealer.getWinningCount() + 1);
                user.setWin(false);
                return;
            }
            dealer.setLosingCount(dealer.getLosingCount() + 1);
            user.setWin(true);
        });
    }

    private boolean dealerResultValidation(User user) {
        return dealer.getCardHandScore() <= CardBundle.BLACK_JACK && dealer.getCardHandScore() >= user.getCardHandScore();
    }
}
