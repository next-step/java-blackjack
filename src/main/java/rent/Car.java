package rent;

public abstract class Car {

    private static final String NEWLINE = System.getProperty("line.separator");
    private final Integer distance;
    private final Integer rating;
    private final String name;

    public Car(Integer distance, Integer rating, String name) {
        this.distance = distance;
        this.rating = rating;
        this.name = name;
    }

    double getChargeQuantity() {
        return (double) distance / rating;
    }

    String generateReport() {
        return String.format("%s : %d리터%s", name, (int) getChargeQuantity(), NEWLINE);
    }
}