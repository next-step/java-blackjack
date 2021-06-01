package blackjack.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BlackJackGame {

    Stream<Gamer> Gamers ;

    public void getPlayerName(String GamerName){

      Gamers = Arrays.stream(GamerName.split(",| ,"))
                .map(Gamer::new)//.map(name -> new Gamer(name))
                ;

      //Gamers.forEach(player -> System.out.println(player.getName()));
    }



}
