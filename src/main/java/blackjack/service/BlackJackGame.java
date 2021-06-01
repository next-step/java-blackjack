package blackjack.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlackJackGame {

    List<Player> players;

    CardDeck cardDeck = new CardDeck();

    public  List<Player> getPlayer(String GamerName){

        players = Arrays.stream(GamerName.split(",| ,"))
                .map(Gamer::new)//.map(name -> new Gamer(name))
                .collect(Collectors.toList());

        players.add(new Dealer());

        return players;
    }

    public List<Player> startDraw(){
      players.forEach(players -> players.startDraw(cardDeck));
        return players;
    }

    public void addDraw(){
        players.forEach(player -> player.addDraw(cardDeck));
    }

}
