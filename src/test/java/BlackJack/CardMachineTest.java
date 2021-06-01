package BlackJack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardMachineTest {
    private CardMachine cardMachine;
    private CardPack cardPack;

    @BeforeEach
    void setUp() {
        cardMachine = new CardMachine();
        cardPack = cardMachine.createCards();
    }

    @Test
    void createCard() {
        assertThat(cardPack.getCards().size()).isEqualTo(52);
    }
}
