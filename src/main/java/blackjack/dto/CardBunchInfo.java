package blackjack.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class CardBunchInfo {
    private final List<CardInfo> cardsInfo;
}
