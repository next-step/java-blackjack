package blackjack.domain;

import blackjack.domain.Card.CardType;
import blackjack.domain.Card.CardValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {

    public Participant start() {
        // 덱만들기
        List<CardType> types = Arrays.asList(CardType.values());
        Collections.shuffle(types);

        List<CardValue> values = Arrays.asList(CardValue.values());
        Collections.shuffle(values);

        Deck deck = new Deck(types, values);

        // 사용자 입력
        List<String> name = new ArrayList<>();
        name.add("pobi");
        name.add("jason");

        // 딜러 추가
        Participant dealer = new Dealer("dealer");

        // 사용자 추가
        Players players = Players.from(name);

        // 딜러 , 사용자 에게 카드 2장씩 분배
        dealer.drawCardMultiple(deck, 2);
        players.drawCardMultiple(deck, 2);

        // 받은 카드 상태 출력

        // 사용자 1장씩 뽑기
        players.drawCardMultiple(deck, 1);

        // 딜러 1장 뽑기
        dealer.drawCardMultiple(deck, 1);

        // 사용자별 카드 최종 상태 출력

        // 최종 승패

        // 승자 반환
        return null;
    }
}
