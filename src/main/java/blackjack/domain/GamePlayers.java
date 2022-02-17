package blackjack.domain;

public abstract class GamePlayers {

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

    public String getPlayerName() {
        return playerName;
    }

    public OwnCards myOwnCards() {
        return ownCards;
    }
}
