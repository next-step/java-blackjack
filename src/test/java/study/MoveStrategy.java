package study;

@FunctionalInterface
public interface MoveStrategy {
    //    boolean isMovable(Car car, int value);
    boolean isMovable();

    default int test(){
        return 0;
    }
}
