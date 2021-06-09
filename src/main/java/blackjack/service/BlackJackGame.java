package blackjack.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BlackJackGame {
    private final static String SPACE = " ";
    private final static String EMPTY = "";
    private final static String COMMA_DELIMITER = ",";
    private final static int TWENTY_ONE = 21;
    private final static int TEN = 10;
    private final static int ZERO = 0;

    private List<Player> players;
    private CardDeck cardDeck = new CardDeck();
    private List<Player> gamers;
    private Dealer dealer = new Dealer();

    public List<Player> getPlayer(String gamerName) {

        players = Arrays.stream(gamerName.replace(SPACE, EMPTY).split(COMMA_DELIMITER))
                .map(Gamer::new)//.map(name -> new Gamer(name))
                .collect(Collectors.toList());
        players.add(0, dealer);

        return players;
    }

    public List<Player> startDraw() {
        players.forEach(players -> players.startDraw(cardDeck));
        return players;
    }

    public void addDraw() {
        players.forEach(player -> player.addDraw(cardDeck));
    }

    public void setZero() {

        players.forEach(player -> {
            if (player.getScore() > TWENTY_ONE) {
                player.setScore(ZERO);
            }
        });

    }

    public void aceCheck() {
        for (Player player : players) {
            for (Card card : player.getCards()) {
                if (card.getCardNumber().equals(CardNumber.ACE)) {
                    if (player.sumScore() + TEN < TWENTY_ONE) {
                        player.setScore(player.sumScore() + TEN);
                    }
                }
            }
        }
    }

    public List<Player> resultGamer() {
        gamers = players.stream()
                .filter(Player::isGamer)
                .collect(Collectors.toList());
        gamers.forEach(gamer -> gamer.result(dealer.getScore()));
        gamers.forEach((gamer -> dealer.result(gamer.getScore())));
        return gamers;
    }

    public void outputResult() {
        players.forEach(Player::outputResult);
    }
}
