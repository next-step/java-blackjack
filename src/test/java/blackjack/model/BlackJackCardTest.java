package blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BlackJackCardTest {
    public BlackJackCard blackJackCard;
    public final static int ALL_CARD_COUNT = 52;

    @BeforeEach
    void beforeEach() {
        blackJackCard = BlackJackCard.of();
    }

    @DisplayName("BlackJackCard 생성 테스트")
    @Test
    public void initTest() {
        CardBundle cardBundle = blackJackCard.getCardBundle();

        for (Card card : cardBundle.getCards()) {
            System.out.println(card.getSymbol() + " " + card.getType());
        }
        assertThat(blackJackCard.getCardBundle().getCards().size()).isEqualTo(ALL_CARD_COUNT);
    }

    @DisplayName("Pick 과정 테스트")
    @Test
    public void pickTest() {
        blackJackCard.pickOneCard();
        assertThat(blackJackCard.getCardBundle().getCards().size()).isEqualTo(ALL_CARD_COUNT - 1);
    }

}