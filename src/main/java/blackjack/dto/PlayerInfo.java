package blackjack.dto;

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
}
