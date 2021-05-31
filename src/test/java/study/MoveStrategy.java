package study;

@FunctionalInterface // 꼭붙이기
public interface MoveStrategy {//추상메서드를 무조건 하나만 가진다.디폴트 메소드는 여러게 가능
    boolean isMovable();
}
