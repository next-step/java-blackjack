package blackJack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DeckTest {

    @DisplayName("Deck은 Card의 배열을 가지고 있다.")
    @Test
    void Card의_배열을_가지고_있다() {
        Deck deck = Deck.create();
        Card card = Card.of("스페이드", "3");
        deck.append(card);
        assertThat(deck.getDeck()).isEqualTo(Arrays.asList(card));
    }


    static Stream<Arguments> generateNormalDeck() {
        return Stream.of(
            arguments(Arrays.asList(Card.of("다이아몬드", "3")), 3),
            arguments(Arrays.asList(Card.of("다이아몬드", "9")), 9),
            arguments(Arrays.asList(Card.of("스페이드", "10")), 10)
        );
    }

    @DisplayName("일반적인 Deck의 score를 계산할 수 있다.")
    @ParameterizedTest
    @MethodSource("generateNormalDeck")
    void 일반적인_deck의_score를_계산할_수_있다(List<Card> cards, int score) {
        Deck deck = Deck.from(cards);
        assertThat(deck.getScore()).isEqualTo(score);
    }


    static Stream<Arguments> generateCharTypeDeck() {
        return Stream.of(
            arguments(Arrays.asList(Card.of("다이아몬드", "J")), 10),
            arguments(Arrays.asList(Card.of("스페이드", "Q")), 10),
            arguments(Arrays.asList(Card.of("하트", "K")), 10)
        );
    }

    @DisplayName("JQK 카드를 가진 덱의 score를 계산할 수 있다.")
    @ParameterizedTest
    @MethodSource("generateCharTypeDeck")
    void JQK의_score는_10이다(List<Card> cards, int score) {
        Deck deck = Deck.from(cards);
        assertThat(deck.getScore()).isEqualTo(score);
    }


    static Stream<Arguments> generateAceDeck() {
        return Stream.of(
            arguments(Arrays.asList(Card.of("다이아몬드", "3")), 3),
            arguments(Arrays.asList(
                Card.of("하트", "3"),
                Card.of("스페이드", "A"),
                Card.of("클로버", "9")
            ), 13),
            arguments(Arrays.asList(
                Card.of("하트", "10"),
                Card.of("스페이드", "A")
            ), 21),
            arguments(Arrays.asList(
                Card.of("하트", "A"),
                Card.of("스페이드", "A")
            ), 12),
            arguments(Arrays.asList(
                Card.of("하트", "A"),
                Card.of("스페이드", "A"),
                Card.of("클로버", "A")
            ), 13)
        );
    }

    @DisplayName("ACE의 score를 계산할 수 있다.")
    @ParameterizedTest
    @MethodSource("generateAceDeck")
    void A_score를_계산할_수_있다(List<Card> cards, int score) {
        Deck deck = Deck.from(cards);
        assertThat(deck.getScore()).isEqualTo(score);
    }
}
