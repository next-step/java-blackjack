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

    private Cards sut;

    @BeforeEach
    void before() {
        sut = new Cards();
    }

    @DisplayName("카드 한장을 뽑는다.")
    @Test
    void GivenNothing_When카드_뽑기_Then카드() {
        // When
        final Card card = sut.draw();

        // Then
        assertThat(card).isNotNull();
    }

    @DisplayName("카드를 뽑을때 남은 카드가 없으면 예외를 발생시킨다.")
    @Test
    void Given빈_덱_When카드_뽑기_Then예외_발생() {
        // Given
        final List<Card> cards = Arrays.stream(Pattern.values())
            .flatMap(pattern ->
                Arrays.stream(Rank.values())
                    .map(rank -> new Card(pattern, rank))
                    .collect(Collectors.toList()).stream())
            .collect(Collectors.toList());

        for (Card card : cards) {
            sut = sut.remove(card);
        }

        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> sut.draw());
    }

    @DisplayName("카드를 전부 뽑아 덱이 제대로 생성되었는지 확인한다.")
    @Test
    void GivenNothing_When카드_전부_뽑기_Then중복되지_않은_모든_카드() {
        // When
        final Set<Card> cards = IntStream.range(0, 52).mapToObj(i -> {
                Card card = sut.draw();
                sut.remove(card);
                return card;
            })
            .collect(Collectors.toSet());

        // Then
        assertThat(cards.size()).isEqualTo(52);
    }
}
