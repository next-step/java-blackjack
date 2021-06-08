package study;

@FunctionalInterface
public interface MoveStrategy {//추상메소드를 하나만 써야함
    boolean isMovable();

    //구현 메소드
    // 기능 : 하위호환성
    default int test(){
        return 1;
    }
}
