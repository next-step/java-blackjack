package blackjack.dto;

import blackjack.domain.Denomination;
import blackjack.domain.Suit;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class CardInfo {
    private final String name;

    public CardInfo(Denomination denomination, Suit suit) {
        this.name = denomination.getName() + suit.getName();
    }
}
