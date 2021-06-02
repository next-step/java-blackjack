package blackjack.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BlackJackGame {

    List<Player> players;

    CardDeck cardDeck = new CardDeck();
    Dealer dealer = new Dealer();

    public List<Player> getPlayer(String GamerName) {

        players = Arrays.stream(GamerName.split(",| ,"))
                .map(Gamer::new)//.map(name -> new Gamer(name))
                .collect(Collectors.toList());

        players.add(dealer);

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
            if (player.getScore() > 21) {
                player.setScore(0);
            }
        });
    }
    public void resultGamer() {
        List<Player> gamers = players.stream()
                .filter(Player::isGamer)
                .collect(Collectors.toList());
        gamers.forEach(gamer -> gamer.result(dealer.getScore()));
        gamers.forEach((gamer -> dealer.result(gamer.getScore())));
    }
}
