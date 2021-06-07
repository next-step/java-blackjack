package blackjack.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DealerTest {

    Dealer dealer = new Dealer();

    @BeforeEach
    void set() {

        dealer.setScore(20);
    }

    @Test
    void result_win() {
        dealer.result(19);
        Map<Result, Long> map = dealer.getResultList().stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        assertThat(map.get(Result.win)).isEqualTo(1);
    }

    @Test
    void result_lose() {
        dealer.result(21);

        Map<Result, Long> map = dealer.getResultList().stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        assertThat(map.get(Result.lose)).isEqualTo(1);
    }

    @Test
    void result_draw() {
        dealer.result(20);
        Map<Result, Long> map = dealer.getResultList().stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        assertThat(map.get(Result.draw)).isEqualTo(1);
    }

    @Test
    void result_1win_and_1lose() {

        dealer.result(19);
        dealer.result(21);

        Map<Result, Long> map = dealer.getResultList().stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        assertAll("result",
                () -> assertEquals(map.get(Result.win), 1),
                () -> assertEquals(map.get(Result.lose), 1)
        );
    }


}
