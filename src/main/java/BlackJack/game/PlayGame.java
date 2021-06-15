package BlackJack.game;

import BlackJack.actor.Dealer;
import BlackJack.actor.Player;
import BlackJack.actor.Players;
import BlackJack.card.Card;
import BlackJack.card.CardMachine;
import BlackJack.card.CardPack;

import java.util.Random;

public class PlayGame {
    private CardMachine cardMachine = new CardMachine();
    private final CardPack cardPack = cardMachine.createCards();
    private Random random = new Random();
    private Players players;
    private Dealer dealer;

    public PlayGame(Players players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
    }

    public void drawCardPlayer(Player player) {
        int randomIndexPlayer = random.nextInt(cardPack.getCards().size());
        Card get_CardPlayer = cardPack.getCards().get(randomIndexPlayer);
        player.getCard(get_CardPlayer);
        cardPack.getCards().remove(randomIndexPlayer);
    }

    public void drawCardDealer() {
        int randomIndexDealer = random.nextInt(cardPack.getCards().size());
        Card get_CardDealer = cardPack.getCards().get(randomIndexDealer);
        dealer.getCard(get_CardDealer);
        cardPack.getCards().remove(randomIndexDealer);
    }

    public void gameStart(int count) {
        for (int i = 0; i < count; i++) {
            for (Player player : players.getPlayers()) {
                this.drawCardPlayer(player);
            }
            this.drawCardDealer();
        }
    }
}
