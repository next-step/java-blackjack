package blackjack.service;

import blackjack.controller.BlackJackMain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlackJackGame {

    public void getPlayerName(String playerName){

        List<String> playerNames = Arrays.asList(playerName.split(",| ,"));

        Stream<Player> playerStream = playerNames.stream()
                .map(name -> new Player(name))
                ;

        playerStream.forEach(player -> System.out.println(player.getName()));
    }
}
