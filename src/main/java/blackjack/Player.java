package blackjack;

public class Player {
    private String name;
    private Cards cards;

    public boolean result;

    public Player(String name){
        this.name = name;
        this.cards = new Cards();
    }

    public String getName() {
        return this.name;
    }

    public Integer getSum() {
        return cards.getCards().stream()
                .map(card -> card.toInt())
                .reduce(0, Integer::sum);
    }

    public void add(Card card) {
       cards.push(new Card(card));
    }
}
