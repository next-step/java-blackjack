package blackjack.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private static final int PASS_CARD_NUMBER = 2;
    private final List<Player> players;
    private final Dealer dealer;

    public Game(Dealer dealer, List<Player> players) {
        this.players = players;
        this.dealer = dealer;

    }

    public Game(List<String> playerNames){
        this(new Dealer(handOutCards()), playerNames.stream()
            .map(name -> createPlayer(name))
            .collect(Collectors.toList()));
    }

    private static Player createPlayer(String name) {
        return new Player(name, handOutCards());
    }

    private static Cards handOutCards(){
        return new Cards(CardDeck.pop(PASS_CARD_NUMBER));
    }

    public List<Player> distributeCardsPlayer(){
        return players;
    }




}
