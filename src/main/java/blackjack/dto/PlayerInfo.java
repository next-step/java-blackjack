package blackjack.dto;

import java.util.Objects;

public class PlayerInfo {
    private final NameInfo nameInfo;
    private final CardBunchInfo cardBunchInfo;

    public PlayerInfo(NameInfo nameInfo, CardBunchInfo cardBunchInfo) {
        this.nameInfo = nameInfo;
        this.cardBunchInfo = cardBunchInfo;
    }

    public NameInfo getNameInfo() {
        return nameInfo;
    }

    public CardBunchInfo getCardBunchInfo() {
        return cardBunchInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerInfo that = (PlayerInfo) o;
        return Objects.equals(nameInfo, that.nameInfo) && Objects.equals(cardBunchInfo, that.cardBunchInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameInfo, cardBunchInfo);
    }
}
