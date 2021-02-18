package rent;

public class Avante extends Car {

    private final static String NAME = "Avante";
    private final static Integer RATING = 15;

    public Avante(int distance) {
        super(distance, RATING, NAME);
    }
}
