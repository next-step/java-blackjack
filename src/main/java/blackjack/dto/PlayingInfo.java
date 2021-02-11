package blackjack.dto;

import java.util.List;

public class PlayingInfo {
    private final String name;
    private final List<String> cards;
    private final Integer score;

    public static class Builder {
        private String name = null;
        private List<String> cards = null;
        private Integer score = null;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder cardBunch(List<String> cards) {
            this.cards = cards;
            return this;
        }

        public Builder score(Integer score) {
            this.score = score;
            return this;
        }

        public PlayingInfo build() {
            return new PlayingInfo(this);
        }
    }

    private PlayingInfo(Builder builder) {
        this.name = builder.name;
        this.cards = builder.cards;
        this.score = builder.score;
    }

    public String getName() {
        if (name == null) {
            throw new RuntimeException("Cannot use unintialized data");
        }
        return name;
    }

    public List<String> getCards() {
        if (cards == null) {
            throw new RuntimeException("Cannot use unintialized data");
        }
        return cards;
    }

    public Integer getScore() {
        if (score == null) {
            throw new RuntimeException("Cannot use unintialized data");
        }
        return score;
    }
}