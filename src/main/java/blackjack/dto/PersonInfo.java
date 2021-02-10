package blackjack.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class PersonInfo {
    private final NameInfo nameInfo;
    private final CardBunchInfo cardBunchInfo;
}
