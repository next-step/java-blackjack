package blackjack.domain;

public abstract class GamePlayers {

    private static final int INIT_CNT = 2;

    protected final String playerName;
    protected final OwnCards ownCards;

    protected GamePlayers(String playerName) {
        this.playerName = playerName;
        this.ownCards = new OwnCards();
    }

    protected GamePlayers(String playerName, OwnCards ownCards) {
        this.playerName = playerName;
        this.ownCards = ownCards;
    }

    public abstract boolean isAvailDraw();

    public void initOwnCards(Deck deck) {
        for (int i = 0; i < INIT_CNT; i++) {
            ownCards.addCard(deck.cardDraw());
        }
    }

    public void drawOneCards(Deck deck) {
        ownCards.addCard(deck.cardDraw());
    }

    public String getPlayerName() {
        return playerName;
    }

    public OwnCards myOwnCards() {
        return ownCards;
    }
}
