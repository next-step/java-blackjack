package blackJack.domain;

import java.util.List;

public class BlackJack {

    private final GameUser gameUser;
    private final GameCard gameCard;

    private BlackJack(List<String> userNames) {
        this.gameUser = GameUser.from(userNames);
        this.gameCard = GameCard.create();
        cardShuffle();
    }

    public static BlackJack from(List<String> userNames) {
        return new BlackJack(userNames);
    }

    public List<User> getGameUsers() {
        return gameUser.getGameUsers();
    }

    public List<Card> getGameCard() {
        return gameCard.getGameCard();
    }

    private void cardShuffle() {
        gameCard.shuffle();
    }

    public void gameStart() {
        // 유저별 카드 나눠주기
    }
}
