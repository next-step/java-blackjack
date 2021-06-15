package blackjackgame.model.player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final static int TWENTY_ONE = 21;
    private final static int TEN = 10;
    private final static int ZERO = 0;
    private final static String SPACE = " ";
    private final static String EMPTY = "";
    private final static String COMMA_DELIMITER = ",";


    private List<Player> players;
    private Dealer dealer = new Dealer();
    private List<Player> gamers;

    public Players(String gamerName){
        players = Arrays.stream(gamerName.replace(SPACE, EMPTY).split(COMMA_DELIMITER))
                .map(Gamer::new)//.map(name -> new Gamer(name))
                .collect(Collectors.toList());
        players.add(0, dealer);
    }

    public List<Player> getPlayers() {
        return players;
    }
}
