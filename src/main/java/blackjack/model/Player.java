package blackjack.model;

import blackjack.model.strategy.ReceiveCardStrategy;

import java.util.List;

public class Player {
    private final PlayerInformation playerInformation;
    private final ReceiveCardStrategy receiveCardStrategy;

    public Player(String name, ReceiveCardStrategy receiveCardStrategy) {
        this.playerInformation = new PlayerInformation(name, new BunchOfCard());
        this.receiveCardStrategy = receiveCardStrategy;
    }

    public void addCard(Card card) {
        this.playerInformation.addCard(card);
    }

    public void addSeveralCard(List<Card> cards) {
        for (Card card : cards) {
            addCard(card);
        }
    }

    public int getCardValueSum() {
        return this.playerInformation.getCardValueSum();
    }

    public List<String> getCardNames() {
        return playerInformation.getCardNames();
    }

    public boolean canReceiveCard() {
        return getCardValueSum() <= receiveCardStrategy.getReceiveCardCondition();
    }

    public String getName() {
        return playerInformation.getName();
    }

}
