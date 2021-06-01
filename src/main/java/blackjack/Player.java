package blackjack;

import java.util.List;

public class Player {
    private final String name;
    private final BunchOfCard bunchOfCard;

    public Player(String name) {
        validateNullInput(name);
        this.name = name;
        this.bunchOfCard = new BunchOfCard();
    }

    private void validateNullInput(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름을 입력하지 않으면 생성할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        this.bunchOfCard.addCard(card);
    }

    public int getCardValueSum() {
        return this.bunchOfCard.getCardValueSum();
    }

    public List<String> getCardNames() {
        return bunchOfCard.getCardNames();
    }
}
