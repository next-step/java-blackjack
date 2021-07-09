package study;

public class Car {
        private final String name;
        private int position;

        public Car(final String name, final int position) {
            this.name = name;
            this.position = position;
        }

        // 기존에 진행하던 방식
    /*
        public void move(int number) {
        if (number >= 4) {
            position = position +1;
        }
    }
     */

        // 오늘 인터페이스 만들어서 테스트 진행 -> MoveStrategy class
        // 외부에서 만든 MoveStrategy 의존성을 주입
        // Car는 가변 객체(position이 움직이므로)
        // 따라서 움직임에 대한 부분을 Car객체 새로 생성하고 return하기
    public Car move(final MoveStrategy moveSTrategy) {
        if (moveSTrategy.isMovable()) {
            return new Car(name, position +1);
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
