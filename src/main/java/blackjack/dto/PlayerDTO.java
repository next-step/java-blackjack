package blackjack.dto;

import blackjack.domain.Dealer;
import blackjack.domain.Player;

public class PlayerDTO {
    private final String name;
    private final String cards;

    private PlayerDTO(String name, String cards) {
        this.name = name;
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public String getCards() {
        return cards;
    }

    public static PlayerDTO from(Dealer dealer) {
        return new PlayerDTO(
            "딜러",
            dealer.openOneCard()
        );
    }

    public static PlayerDTO from(Player player) {
        return new PlayerDTO(
            player.getName(),
            player.getAllCards()
        );
    }
}
