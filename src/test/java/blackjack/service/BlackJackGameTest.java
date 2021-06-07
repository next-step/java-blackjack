package blackjack.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BlackJackGameTest {
    BlackJackGame blackJackGame = new BlackJackGame();

    @BeforeEach
    void set(){
        blackJackGame.getPlayer("1,2");
    }

}
