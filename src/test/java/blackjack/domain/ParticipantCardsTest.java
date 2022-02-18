package blackjack.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import blackjack.domain.Card.CardType;
import blackjack.domain.Card.CardValue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ParticipantCardsTest {

    @Test
    void 카드총합_구하기() {
        // given
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardType.CLOVER, CardValue.FIVE));
        cards.add(new Card(CardType.CLOVER, CardValue.ACE));
        cards.add(new Card(CardType.CLOVER, CardValue.TWO));
        ParticipantCards participantCards = new ParticipantCards(cards);

        int score = participantCards.sumCardScore();

        assertThat(score).isEqualTo(18);
    }

    @Test
    void 카드총합_구하기2() {
        // given
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardType.CLOVER, CardValue.FIVE));
        cards.add(new Card(CardType.CLOVER, CardValue.TWO));
        ParticipantCards participantCards = new ParticipantCards(cards);

        int score = participantCards.sumCardScore();

        assertThat(score).isEqualTo(7);
    }

    @Test
    void 카드총합_구하기3() {
        // given
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardType.CLOVER, CardValue.FIVE));
        cards.add(new Card(CardType.CLOVER, CardValue.NINE));
        cards.add(new Card(CardType.CLOVER, CardValue.FIVE));
        cards.add(new Card(CardType.CLOVER, CardValue.ACE));
        cards.add(new Card(CardType.CLOVER, CardValue.TWO));
        ParticipantCards participantCards = new ParticipantCards(cards);

        int score = participantCards.sumCardScore();

        assertThat(score).isEqualTo(22);
    }
}
