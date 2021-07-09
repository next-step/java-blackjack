package blackjack;

import blackjack.model.Card;
import blackjack.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    Player player;

    @BeforeEach
    void setUp() {
        player = new Player("yerim");
        player.initialCardSetting();
    }

    @DisplayName(value = "플레이어 이름 가져오기")
    @Test
    void get_name() {
        System.out.println(player.getName());
        assertThat(player.getName()).isEqualTo("yerim");
    }

    @DisplayName(value = "플레이어가 가지고 있는 카드들 보기")
    @Test
    void show_cards() {
        List<Card> cards = player.getCards();
        for (Card card : cards) {
            System.out.println(card.getDenominationName() + " " + card.getSuitName());
        }
    }

    @DisplayName(value = "플레이어가 가지고 있는 카드들 점수 보기")
    @Test
    void add_score() {
        List<Card> cards = player.getCards();
        for (Card card : cards) {
            System.out.println(card.getDenominationName() + " " + card.getSuitName());
        }
        System.out.println(player.score());
    }

    @DisplayName(value = "추가 카드 뽑기")
    @Test
    void additional_card_setting() {
        List<Card> cards = player.getCards();
        for (Card card : cards) {
            System.out.println(card.getDenominationName() + " " + card.getSuitName());
        }
        System.out.println();

        player.additionalCardSetting();
        cards = player.getCards();
        for (Card card : cards) {
            System.out.println(card.getDenominationName() + " " + card.getSuitName());
        }
    }
}
