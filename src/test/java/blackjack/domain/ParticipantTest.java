package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParticipantTest {

    @DisplayName("참가자_생성_테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "json"})
    void createParticipantTest(String name) {
        Participant participant = new Participant(name);
        assertThat(participant.getName()).isEqualTo(name);
    }

}