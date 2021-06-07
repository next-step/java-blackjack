package blackjack;

public class Gambler {
    String name;
    String card;

    public Gambler(String card) {
        this("dealer",card);
    }

    public Gambler(String name, String card) {
        this.name = name;
        this.card = card;
    }
}
