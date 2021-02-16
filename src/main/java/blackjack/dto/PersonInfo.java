package blackjack.dto;

import java.util.Objects;

public class PersonInfo {

    private final NameInfo nameInfo;
    private final CardBunchInfo cardBunchInfo;
    private final Integer score;

    public PersonInfo(NameInfo nameInfo, CardBunchInfo cardBunchInfo) {
        this.nameInfo = nameInfo;
        this.cardBunchInfo = cardBunchInfo;
        this.score = 0;
    }

    public PersonInfo(NameInfo nameInfo, CardBunchInfo cardBunchInfo, Integer score) {
        this.nameInfo = nameInfo;
        this.cardBunchInfo = cardBunchInfo;
        this.score = score;
    }

    public NameInfo getNameInfo() {
        return nameInfo;
    }

    public CardBunchInfo getCardBunchInfo() {
        return cardBunchInfo;
    }

    public Integer getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonInfo that = (PersonInfo) o;
        return Objects.equals(nameInfo, that.nameInfo) && Objects.equals(cardBunchInfo, that.cardBunchInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameInfo, cardBunchInfo);
    }
}
