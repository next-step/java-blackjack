package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HandsTest {

    @DisplayName("참가자 패의 카드 값을 더해 반환한다.")
    @Test
    void Given카드_2장_When합_구하기_Then합_반환() {
        // Given
        final Hands hands = new Hands(Arrays.asList(
            new Card(Pattern.CLUB, Rank.TEN),
            new Card(Pattern.SPADE, Rank.TEN)));

        // Then
        assertThat(hands.getScore()).isEqualTo(20);
    }

    @DisplayName("초기에 ACE를 한장 가지고 있는 경우 ACE를 11로 계산한다.")
    @Test
    void GivenAce_한_장_포함된_카드_2장_When합_구하기_Then합_반환() {
        // Given
        final Hands hands = new Hands(Arrays.asList(
            new Card(Pattern.CLUB, Rank.ACE),
            new Card(Pattern.SPADE, Rank.TEN)));

        // Then
        assertThat(hands.getScore()).isEqualTo(21);
    }

    @DisplayName("초기에 ACE를 2장 갖고 있는 경우, 합을 12로 계산한다.")
    @Test
    void GivenAce_2장_When합_구하기_Then합_반환() {
        // Given
        final Hands hands = new Hands(Arrays.asList(
            new Card(Pattern.CLUB, Rank.ACE),
            new Card(Pattern.SPADE, Rank.ACE)));

        // Then
        assertThat(hands.getScore()).isEqualTo(12);
    }

    @DisplayName("참가자의 카드 패에 ACE를 추가할 때 11로 더해도 21을 넘지 않으면 ACE를 11로 계산한다.")
    @Test
    void GivenAce_When합_구하기_Then11을_더한_스코어() {
        // Given
        final Hands hands = new Hands(Arrays.asList(
            new Card(Pattern.CLUB, Rank.TWO),
            new Card(Pattern.SPADE, Rank.TWO)));

        // When
        hands.add(new Card(Pattern.CLUB, Rank.ACE));

        // Then
        assertThat(hands.getScore()).isEqualTo(15);
    }

    @DisplayName("참가자의 카드 패에 ACE를 추가할 때 11을 더헀을 때, 21을 넘으면 ACE를 1로 계산한다.")
    @Test
    void GivenAce_When합_구하기_Then1을_더한_스코어() {
        // Given
        final Hands hands = new Hands(Arrays.asList(
            new Card(Pattern.CLUB, Rank.TEN),
            new Card(Pattern.SPADE, Rank.TEN)));

        // When
        hands.add(new Card(Pattern.CLUB, Rank.ACE));

        // Then
        assertThat(hands.getScore()).isEqualTo(21);
    }
}
