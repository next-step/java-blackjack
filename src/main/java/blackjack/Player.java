package blackjack;

public interface Player {
    String getName();

    void receiveCard();

    Pocket getCardStats();

    String exportCardStats();
}