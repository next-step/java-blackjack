package study;


public class Car {
    private final int position;
    private final String name;

    public Car(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public Car move(final MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            return new Car(name, position + 1);
        }
        return this;
    }

    public int getPosition() {
        return position;
    }
}
