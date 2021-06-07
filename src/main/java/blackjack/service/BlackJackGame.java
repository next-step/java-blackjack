package blackjack.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BlackJackGame {
    final static String SPACE = " ";
    final static String EMPTY = "";
    final static String COMMA_DELIMITER = ",";
    List<Player> players;

    CardDeck cardDeck = new CardDeck();
    Dealer dealer = new Dealer();

    public List<Player> getPlayer(String GamerName) {


        players = Arrays.stream(GamerName.replace(SPACE, EMPTY).split(COMMA_DELIMITER))
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

        aceCheck();

        players.forEach(player -> {
            if (player.getScore() > 21) {
                player.setScore(0);
            }
        });

    }

    private void aceCheck() {
        for (Player player : players) {
            for (Card card : player.getCards()) {
                if (card.getCardNumber().equals(CardNumber.ACE)) {
                    if (player.getScore() + 10 < 21) {
                        player.setScore(player.getScore() + 10);
                    }
                }
            }
        }
    }

    public void resultGamer() {
        List<Player> gamers = players.stream()
                .filter(Player::isGamer)
                .collect(Collectors.toList());
        gamers.forEach(gamer -> gamer.result(dealer.getScore()));
        gamers.forEach((gamer -> dealer.result(gamer.getScore())));
    }

    public void outputResult() {

        players.stream()
                .forEach(player -> player.outputResult());
    }
}
