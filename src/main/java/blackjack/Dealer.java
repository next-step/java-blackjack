package blackjack;

public class Dealer {
    private final Deck deck;
    private Player player;

    public Player getPlayer() {
        return player;
    }

    private Integer cardCount;

    public Dealer(){
        deck = new Deck();
        player = new Player("Dealer");
        cardCount = 0;
    }

    public void deal(Player player) {
        Card card = deck.getOneCard(cardCount++);
        player.add(card);
    }

    public boolean isWin(Player player) {
        return player.getSum() > this.player.getSum();
    }
}
