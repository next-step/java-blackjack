package blackjack.domain;

public interface CardAddible {

    Cards cards();

    void addCard(Card card);

    boolean isEnd();

    CardAddible judge();
}