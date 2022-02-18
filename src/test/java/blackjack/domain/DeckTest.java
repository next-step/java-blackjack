package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import blackjack.domain.Card.CardType;
import blackjack.domain.Card.CardValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class DeckTest {
    @DisplayName("덱이 생성 됐는지 확인")
    @Test
    void deckCreated() {
        // given
        List<CardType> types = Arrays.asList(CardType.values());
        List<CardValue> values = Arrays.asList(CardValue.values());
        Deck deck = new Deck(types, values);

        // when
        Deque<Card> deckTmp = new ArrayDeque<>();
        deckTmp.addAll(deck.drawMultiple(52));

        // then
        for(int i = 0; i < deckTmp.size() ; i++) {
            CardValue deckCardValue = values.get(i % values.size());
            Card deckTmpCard = deckTmp.pop();
            assertThat(deckCardValue.isEqualCardValue(deckTmpCard));
        }
    }

    @DisplayName("덱이 섞였는지 확인")
    @Test
    void shuffledDeckCreated() {
        // given
        List<CardType> types = Arrays.asList(CardType.values());
        Collections.shuffle(types);

        List<CardValue> values = Arrays.asList(CardValue.values());
        Collections.shuffle(values);

        Deck deck = new Deck(types, values);

        // when
        Deque<Card> deckTmp = new ArrayDeque<>();
        deckTmp.addAll(deck.drawMultiple(52));

        // then
        for(int i = 0; i < deckTmp.size() ; i++) {
            CardValue deckCardValue = values.get(i % values.size());
            Card deckTmpCard = deckTmp.pop();
            assertThat(deckCardValue.isEqualCardValue(deckTmpCard));
        }
    }
}