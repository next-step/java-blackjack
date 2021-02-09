package blackjack.domain;

import blackjack.dto.NameInfo;
import blackjack.dto.PersonInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {
    private static Person testPlayer;

    @BeforeAll
    static void beforeAll() {
        testPlayer = Person.createPlayer(
            "player",
            new PlayerCardBunch(
                List.of(1, 7, 10),
                Suit.HEARTS
            )
        );
    }

    @DisplayName("Check person draw card well")
    @Test
    void drawCard() {
        Person player = Person.createPlayer(
            "player",
            new PlayerCardBunch()
        );

        Deck deck = new Deck(
            new ArrayList<>() {{
                add(new Card(Denomination.ACE, Suit.HEARTS));
                add(new Card(Denomination.TEN, Suit.HEARTS));
            }}
        );

        assertEquals(
            new PersonInfo(
                new NameInfo("player"),
                new PlayerCardBunch(
                    List.of(),
                    Suit.HEARTS
                ).getCardBunchInfo()
            ),
            player.getPersonInfo()
        );

        player.drawCard(deck);

        assertEquals(
            new PersonInfo(
                new NameInfo("player"),
                new PlayerCardBunch(
                    List.of(1),
                    Suit.HEARTS
                ).getCardBunchInfo()
            ),
            player.getPersonInfo()
        );
    }

    private static Stream<Arguments> providerIsBustParams() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 10), false),
            Arguments.of(Arrays.asList(10, 9, 8), true)
        );
    }

    @DisplayName("Check if the Player return correct Player information")
    @Test
    void getPersonInfo() {
        assertEquals(
            new PersonInfo(
                new NameInfo("player"),
                new PlayerCardBunch(
                    List.of(1, 7, 10),
                    Suit.HEARTS
                ).getCardBunchInfo()
            ),
            testPlayer.getPersonInfo()
        );
    }

    @DisplayName("Check if the function generate correct result")
    @ParameterizedTest
    @MethodSource("providerGetResultParams")
    void getResult(List<Integer> dealerCards, List<Integer> playerCards, Result expected) {
        assertEquals(
            expected,
            Person.createDealer(
                new DealerCardBunch(dealerCards, Suit.HEARTS)
            ).getResult(
                Person.createPlayer(
                    "player",
                    new PlayerCardBunch(playerCards, Suit.HEARTS)
                )
            )
        );
    }

    private static Stream<Arguments> providerGetResultParams() {
        return Stream.of(
            Arguments.of(List.of(1, 10), List.of(10, 10), Result.WIN),
            Arguments.of(List.of(1, 10), List.of(1, 10), Result.DRAW),
            Arguments.of(List.of(9, 10), List.of(1, 10), Result.LOSE)
        );
    }

    @DisplayName("Check if the Player return correct Player name information")
    @Test
    void getNameInfo() {
        assertEquals(
            new NameInfo("player"),
            testPlayer.getNameInfo()
        );
    }
}