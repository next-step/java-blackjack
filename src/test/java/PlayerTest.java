import Domain.Player;
import Domain.TrumpCard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayerTest {
    @DisplayName("플레이어 생성 확인")
    @Test
    void makePlayer(){
        TrumpCard testCard1 = new TrumpCard(0);
        TrumpCard testCard2 = new TrumpCard(0);

        Player player = new Player("poni", List.of(testCard1, testCard2));

//        assertThat(player.getPlayerScore()).isEqualTo(2);
    }

    @DisplayName("플레이어 카드 추가 확인")
    @Test
    void checkAddCard(){
        TrumpCard testCard1 = new TrumpCard(0);
        TrumpCard testCard2 = new TrumpCard(0);
        ArrayList<TrumpCard> cardList = new ArrayList<>();
        cardList.add(testCard1);
        cardList.add(testCard2);

        Player player = new Player("poni", cardList);
        player.addParticipantCardList(new TrumpCard(0));

        assertThat(player.getParticipantScore()).isEqualTo(13);
    }


}