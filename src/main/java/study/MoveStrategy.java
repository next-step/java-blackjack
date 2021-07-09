package study;

@FunctionalInterface
public interface MoveStrategy {
    // 추상 메소드
    boolean isMovable();

    // 디폴드 메소드
    default int test() {
        return 0;
    }
}
