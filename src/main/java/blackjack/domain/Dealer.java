package blackjack.domain;


import blackjack.util.CardShuffler;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dealer {

    private static final List<String> symbols = Arrays.asList("스페이드", "다이아몬드", "클로버", "하트");
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
            OutputView.printDealerAcceptCard();
            giveCardAfterPick(player);
            score = player.getScore();
        }
    }

    private void giveCardAfterPick(Player player) {
        List<String> stockSymbols = symbols.stream()
            .filter(symbol -> cardPack.getMap().get(symbol).size() > 0)
            .collect(Collectors.toList());

        String symbol = CardShuffler.pickSymbolIn(stockSymbols);
        int cardSize = cardPack.getCardSizeBy(symbol);
        int pickCardIndex = CardShuffler.pickCardIndexIn(cardSize);

        Card pickedCard = cardPack.pickCard(symbol, pickCardIndex);
        player.receiveCard(pickedCard);
    }

    private boolean isLowerThanBlackJack(int score) {
        return score < BLACKJACK;
    }

    private boolean isLowerThanDealerBound(int score) {
        return score < DEALER_BOUND;
    }
}
