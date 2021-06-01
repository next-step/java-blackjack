package BlackJack;

import java.util.List;
import java.util.Random;

public class PlayGame {
    private CardMachine cardMachine = new CardMachine();
    private final CardPack cardPack = cardMachine.createCards();
    private Random random = new Random();
    private List<Player> players;
    private Dealer dealer;

    public PlayGame(List<Player> players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
    }

    public void drawCardPlayer() {
        for (Player player : players) {
            int randomIndexPlayer = random.nextInt(cardPack.getCards().size());
            Card get_CardPlayer = cardPack.getCards().get(randomIndexPlayer);
            player.getCard(get_CardPlayer);
            cardPack.getCards().remove(randomIndexPlayer);
        }
    }

    public void drawCardDealer() {
        int randomIndexDealer = random.nextInt(cardPack.getCards().size());
        Card get_CardDealer = cardPack.getCards().get(randomIndexDealer);
        dealer.getCard(get_CardDealer);
        cardPack.getCards().remove(randomIndexDealer);
    }

    public void playStart(int i) {
        for (int j = 0; j < i; j++) {
            this.drawCardPlayer();
            this.drawCardDealer();
        }
    }

}
