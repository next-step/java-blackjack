package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeckTest {

    private Deck sut;

    @BeforeEach
    void before() {
        sut = new Deck();
    }

    @DisplayName("카드를 한장 뽑는다.")
    @Test
    void GivenNothing_When_Then() {
        assertThat(sut.draw()).isNotNull();
    }

    @DisplayName("참가자들의 초기 패를 뽑는다.")
    @Test
    void Given_When_Then() {
        assertThat(sut.dealInitCards().size()).isEqualTo(2);
    }

    @DisplayName("중복없이 모든 카드가 뽑힌다.")
    @Test
    void GivenNothing_When카드_전부_뽑기_Then중복되지_않은_모든_카드() {

        // When
        final Set<Card> cards = IntStream.range(0, 52)
            .mapToObj(i -> {
                Card card = sut.draw();
                return card;
            })
            .collect(Collectors.toSet());

        // Then
        assertThat(cards.size()).isEqualTo(52);
    }
}
