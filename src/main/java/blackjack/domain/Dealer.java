package blackjack.domain;


import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;

public class Dealer {

    private static final int INITIAL_CARD_QUANTITY = 2;
    private static final int BLACKJACK = 21;
    private static final int DEALER_BOUND = 16;
    private final CardPack cardPack;

    public Dealer(CardPack cardPack) {
        this.cardPack = cardPack;
    }

    public void initializeGame(GamePlayers gamePlayers) {
        List<Player> players = gamePlayers.getPlayers();

        for (int i = 0; i < INITIAL_CARD_QUANTITY; i++) {
            players.stream()
                .forEach(player -> giveCardAfterPick(player));
        }
    }

    public void playGame(GamePlayers gamePlayers) {
        List<Player> players = gamePlayers.getPlayers();

        for (Player player : players) {
            giveCardToPlayer(player);
        }
        for (Player player : players) {
            System.out.println(player.getName()+"의 점수 : "+player.getScore());
        }
    }

    private void giveCardToPlayer(Player player) {
        if (player.isDealer()) {
            giveCardToDealerPlayer(player);
            return;
        }
        giveCardToGeneralPlayer(player);
    }

    private void giveCardToGeneralPlayer(Player player) {
        int score = player.getScore();

        if (isLowerThanBlackJack(score)) {
            OutputView.printQuestionAcceptCard(player);

            while (isLowerThanBlackJack(score) && InputView.getPlayerChoice()) {
                giveCardAfterPick(player);
                OutputView.printCardStatus(player);
                score = player.getScore();
            }
        }
    }

    private void giveCardToDealerPlayer(Player player){
        int score = player.getScore();
        while (isLowerThanDealerBound(score)) {
            OutputView.printDealrAcceptCard();
            giveCardAfterPick(player);
            score = player.getScore();
        }
    }

    private void giveCardAfterPick(Player player) {
        Card pickedCard = cardPack.pickCard();
        player.receiveCard(pickedCard);
    }

    public boolean isLowerThanBlackJack(int score) {
        return score < BLACKJACK;
    }

    public boolean isLowerThanDealerBound(int score) {
        return score < DEALER_BOUND;
    }
}
