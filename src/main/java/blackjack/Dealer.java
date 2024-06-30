package blackjack;

public class Dealer extends Player {
    private final Deck deck;
    private Integer cardCount;


    public Dealer(){
        super("dealer");
        deck = new Deck();
        cardCount = 0;
    }

    public void deal(Player player) {
        Card card = deck.getOneCard(cardCount++);
        player.add(card);
    }

    public boolean isWin(Player player) {
        int dealerSum = getSum();
        int playerSum =  player.getSum();
        if(dealerSum == playerSum) {
            return this.getCount() < player.getCount();
        }
        return dealerSum < playerSum;
    }
}
