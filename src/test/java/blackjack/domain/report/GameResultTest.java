package blackjack.domain.report;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardBundle;
import blackjack.domain.card.Number;
import blackjack.domain.card.Suit;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    void 값이_큰_카드번들과_작은_카드번들을_비교하면_승리를_반환한다() {
        CardBundle largerCardBundle = CardBundle.emptyBundle();
        largerCardBundle.addCard(new Card(Suit.SPADE, Number.ACE));
        largerCardBundle.addCard(new Card(Suit.SPADE, Number.JACK));
        CardBundle smallerCardBundle = CardBundle.emptyBundle();
        smallerCardBundle.addCard(new Card(Suit.CLOVER, Number.TWO));
        GameResult actualResult = GameResult.comparing(largerCardBundle, smallerCardBundle);
        assertThat(actualResult).isEqualTo(GameResult.WIN);
    }

    @Test
    void 값이_같은_카드번들을_비교하면_무승부를_반환한다() {
        CardBundle cardBundle1 = CardBundle.emptyBundle();
        cardBundle1.addCard(new Card(Suit.CLOVER, Number.ACE));
        CardBundle cardBundle2 = CardBundle.emptyBundle();
        cardBundle2.addCard(new Card(Suit.DIAMOND, Number.ACE));
        GameResult actualResult = GameResult.comparing(cardBundle1, cardBundle2);
        assertThat(actualResult).isEqualTo(GameResult.DRAW);
    }

    @Test
    void 값이_작은_카드번들과_큰_카드번들을_비교하면_패배를_반환한다() {
        CardBundle largerCardBundle = CardBundle.emptyBundle();
        largerCardBundle.addCard(new Card(Suit.SPADE, Number.ACE));
        largerCardBundle.addCard(new Card(Suit.SPADE, Number.JACK));
        CardBundle smallerCardBundle = CardBundle.emptyBundle();
        smallerCardBundle.addCard(new Card(Suit.CLOVER, Number.TWO));
        GameResult actualResult = GameResult.comparing(smallerCardBundle, largerCardBundle);
        assertThat(actualResult).isEqualTo(GameResult.LOSE);
    }
}