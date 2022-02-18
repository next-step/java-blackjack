package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.Card.CardType;
import blackjack.domain.Card.CardValue;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @DisplayName("현재 플레이어 카드 뽑고 점수 더하기 (에이스 없음)")
    @Test
    void playerDrawCardWithoutAce() {
        // given
        List<CardType> types = Arrays.asList(CardType.CLOVER);
        List<CardValue> values = Arrays.asList(CardValue.TWO, CardValue.THREE, CardValue.KING);
        Deck deck = new Deck(types, values);

        Participant player = new Player("player");
        player.drawCardMultiple(deck, 1);
        player.drawCardMultiple(deck, 1);
        player.drawCardMultiple(deck, 1);

        // when
        int result = player.sumCardScore();

        // then
        assertThat(result).isEqualTo(15);
    }

    @DisplayName("현재 플레이어 카드 뽑고 점수 더하기 (에이스 있음)")
    @Test
    void playerDrawCardWithAce() {
        // given
        List<CardType> types = Arrays.asList(CardType.CLOVER);
        List<CardValue> values = Arrays.asList(CardValue.TWO, CardValue.THREE, CardValue.ACE, CardValue.ACE);
        Deck deck = new Deck(types, values);

        Participant player = new Player("player");
        player.drawCardMultiple(deck, 1);
        player.drawCardMultiple(deck, 1);
        player.drawCardMultiple(deck, 1);
        player.drawCardMultiple(deck, 1);

        // when
        int result = player.sumCardScore();

        // then
        assertThat(result).isEqualTo(17);
    }
}