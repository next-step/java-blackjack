package blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GamerTest {

    Gamer gamer;

    @BeforeEach
    void set() {
        gamer = new Gamer("1");
        gamer.setScore(20);
    }

    @Test
    void result_win() {
        gamer.result(19);
        assertThat(gamer.getResult()).isEqualTo(Result.win);
    }

    @Test
    void result_lose() {
        gamer.result(21);
        assertThat(gamer.getResult()).isEqualTo(Result.lose);
    }

    @Test
    void result_draw() {
        gamer.result(20);
        assertThat(gamer.getResult()).isEqualTo(Result.draw);
    }
}
