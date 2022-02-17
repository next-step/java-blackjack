package blackjack.dto;

import blackjack.domain.Dealer;
import blackjack.domain.Player;

public class FinalScoreDTO {
    private final String name;
    private final int score;
    private final String cards;

    private FinalScoreDTO(String name, int score, String cards) {
        this.name = name;
        this.score = score;
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getCards() {
        return cards;
    }

    public static FinalScoreDTO from(Dealer dealer) {
        return new FinalScoreDTO(
            "딜러",
            dealer.getScore(),
            dealer.getAllCards()
        );
    }

    public static FinalScoreDTO from(Player player) {
        return new FinalScoreDTO(
            player.getName(),
            player.getScore(),
            player.getAllCards()
        );
    }
}
