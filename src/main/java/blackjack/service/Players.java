package blackjack.service;

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

    Players(String gamerName){
        players = Arrays.stream(gamerName.replace(SPACE, EMPTY).split(COMMA_DELIMITER))
                .map(Gamer::new)//.map(name -> new Gamer(name))
                .collect(Collectors.toList());
        players.add(0, dealer);
    }

    public List<Player> getPlayers() {
        return players;
    }
    public void startDraw(CardDeck cardDeck) {
        players.forEach(players -> players.startDraw(cardDeck));
    }
    public void addDraw(CardDeck cardDeck){
        players.forEach(player -> player.addDraw(cardDeck));
    }
    public void setZero(){
        players.forEach(player -> {
            if (player.getScore() > TWENTY_ONE) {
                player.setScore(ZERO);
            }
        });
    }

    public void aceCheck(){
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

    public void resultGamer(){
        gamers = players.stream()
                .filter(Player::isGamer)
                .collect(Collectors.toList());
        gamers.forEach(gamer -> gamer.result(dealer.getScore()));
        gamers.forEach((gamer -> dealer.result(gamer.getScore())));
    }

    public void outputResult(){
        players.forEach(Player::outputResult);
    }


}
