package blackJack.domain;

public class Score {

    private final int win;
    private final int lose;
    private final int draw;

    private Score() {
        this(0, 0, 0);
    }

    private Score(int win, int lose, int draw) {
        this.win = win;
        this.lose = lose;
        this.draw = draw;
    }

    public static Score create() {
        return new Score();
    }

    public static Score of(int win, int lose, int draw) {
        return new Score(win, lose, draw);
    }

    public int total() {
        return win + lose + draw;
    }

    public Score win() {
        return Score.of(win + 1, lose, draw);
    }

    public Score lose() {
        return Score.of(win, lose + 1, draw);
    }

    public Score draw() {
        return Score.of(win, lose, draw + 1);
    }
}
