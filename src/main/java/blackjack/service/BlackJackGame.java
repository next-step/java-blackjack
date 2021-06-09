package blackjack.service;

public class BlackJackGame {

    private Players players;
    private CardDeck cardDeck = new CardDeck();

    public Players startGame(String gamerName) {
        players =new Players(gamerName);
        players.playersStartDrawCard(cardDeck);
        return players;
    }

    public void addDraw() {
        players.playersAddDrawCard(cardDeck);
    }

    public void setZero() {
        players.setZero();

    }

    public void aceCheck() {
        players.aceCheck();
    }

    public void resultGamer() {
        players.resultGamer();
    }

    public void outputResult() {
        players.outputResult();
    }
}
