package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardsTest {

    private Cards cards;

    @BeforeEach
    void before() {
        cards = Cards.create();
    }

    // 카드 하나 뽑는
    @DisplayName("카드 한장을 뽑는다.")
    @Test
    void GivenNothing_When카드_뽑기_Then카드() {
        // When
        final Card card = cards.drawOne();

        // Then
        assertThat(card).isNotNull();
    }

    // 빈 거 뽑는거
    @DisplayName("빈 카드 목록에서 예외가 발생한다.")
    @Test
    void GivenNothing_When카드_뽑기_Then예외_발생() {
        final List<Card> allCards = Arrays.stream(Pattern.values())
            .flatMap(pattern ->
                Arrays.stream(Rank.values())
                    .map(rank -> new Card(pattern, rank))
                    .collect(Collectors.toList()).stream())
            .collect(Collectors.toList());

        for (Card card : allCards) {
            cards.without(card);
        }

        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> cards.drawOne());
    }

    @DisplayName("카드를 전부 뽑아 덱이 제대로 생성되었는지 확인한다.")
    @Test
    void GivenNothing_When카드_전부_뽑기_Then중복되지_않은_모든_카드() {
        // When
        final Set<Card> allCards = IntStream.range(0, 52).mapToObj(i -> {
                Card card = cards.drawOne();
                cards = cards.without(card);
                return card;
            })
            .collect(Collectors.toSet());

        // Then
        assertThat(allCards.size()).isEqualTo(52);
    }
}
