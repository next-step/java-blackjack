package blackjack.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GamersTest {

    @DisplayName("이름 잘 가져오는지 테스트")
    @ParameterizedTest
    @MethodSource("provideGamersTest")
    void gamersTest(Gamers gamers, List<Gamer> expected) {
        assertEquals(
            gamers.getGamers().stream().map(Gamer::getName).collect(Collectors.toList())
            , new Gamers(expected).getGamers().stream().map(Gamer::getName).collect(Collectors.toList()));
    }

    public static Stream<Arguments> provideGamersTest() {
        return Stream.of(
            Arguments.of(
                new Gamers("daeun,mimi", new Deck()),
                Arrays.asList(
                    new Gamer("daeun", new Deck()),
                    new Gamer("mimi", new Deck())
                )
            ),
            Arguments.of(
                new Gamers("다은,mimi", new Deck()),
                Arrays.asList(
                    new Gamer("다은", new Deck()),
                    new Gamer("mimi", new Deck())
                )
            )
        );
    }

    @DisplayName("이름 형식이 틀린 경우 테스트")
    @ParameterizedTest
    @MethodSource("provideGamersFailTest")
    void gamersFailTest(String gamer, Deck deck){
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Gamers(gamer, deck));
    }

    public static Stream<Arguments> provideGamersFailTest() {
        return Stream.of(
            Arguments.of(
                "daeun   ,   mimi  "
                , new Deck()
            ),
            Arguments.of(
                "daeun   dsgsdg, mimi  "
                , new Deck()
            ),
            Arguments.of(
                "daeun$%$dsgsdg,mimi"
                , new Deck()
            )
        );
    }
}
