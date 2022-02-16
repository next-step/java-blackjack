package blackjack.domain;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Judgement {

    private static final String ERROR_MESSAGE = "현재 참가자가 없습니다";
    private final List<Player> players;

    public Judgement(List<Player> players) {
        this.players = players;
    }

    public List<String> findWinners() {
        int max = findMaxScore();
        return players.stream().filter(player -> player.calculateScore() == max)
            .map(Player::getName)
            .collect(Collectors.toList());
    }

    private int findMaxScore() {
        OptionalInt max = players.stream().mapToInt(Player::calculateScore).max();
        if (!max.isPresent()) {
            throw new RuntimeException(ERROR_MESSAGE);
        }
        return max.getAsInt();
    }


}
