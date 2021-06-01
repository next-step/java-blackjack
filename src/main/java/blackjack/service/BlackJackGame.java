package blackjack.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BlackJackGame {

    public void getPlayerName(String playerName){

        List<String> playerNames = Arrays.asList(playerName.split(",| ,"));

        Stream<Gamer> playerStream = playerNames.stream()
                .map(name -> new Gamer(name))
                ;

        //playerStream.forEach(player -> System.out.println(player.getName()));
    }
}
