# java-blackjack

## 연료 주입 기능 목록

MotorVehicle (Interface)

- 리터당 이동 거리를 반환 getDistancePerLiter
- 여행할 거리를 반환 getTripDistance
- 차종 이름을 반환 getName

Car (abstract class) (implements MotorVehicle)

- 거리에 따른 연료량을 계산 후 반환 getChargeQuantity
- 멤버변수 distance

Sonata, Avante, K5 (extends Car)

- 생성자로 distance 받기
- private static final 로 연비를 가짐. (10km/리터, 15, 13)

RentCompany

- 차 List를 가짐.
- private 생성자
- static create()을 통해 객체 생성
- addCar(Car) 를 통해 차 List에 저장
- generateReport 를 통해 report String 반환

## 블랙잭

[InputView]
-[ ] 플레이어 이름을 입력받는다.
-[ ] 입력받은 플레이어의 이름을 쉼표로 분리한다.
-[ ] 플레이어에게 카드를 추가로 받을 것인지 입력받는다.
    -[ ] y, n으로 입력 받는다.

[OutputView]
-[ ] 딜러와 플레이어의 현재 카드 목록을 출력한다.
    -[ ] 처음 시작때 딜러는 1번째 카드를 비공개하고, 나머지 카드만 출력한다.
-[ ] 딜러와 플레이어의 최종 승패를 출력한다.


-[ ] enum으로 1~10,J,Q,K를 구현한다.
- value
-[ ] enum으로 하트,스페이드,다이아몬드,클로버를 구현한다.
- shape
-[ ] value와 shape를 합쳐 한 장의 카드를 생성한다.

[Cards]
-[ ] 카드 목록을 일급컬렉션화
-[ ] 전체 숫자 합이 특정 값을 초과하는지 안하는지 판단
 [cardDeck]
-[ ] 카드를 shuffle한다.
-[ ] 딜러와 플레이어에게 카드 두장씩 나눠준다.
 [PlayerCards]
 플레이어이름, Cards cards
-[ ] 현재 보유하고 있는 카드의 합을 구한다.
-[ ] 카드의 합이 21 이하이면 카드를 추가로 뽑을 것인지 질문한다.
 [DealerCards]
-[ ] 플레이어들의 카드 추가 여부가 모두 정해진 뒤 카드를 추가로 받는다.
-[ ] 카드의 합계가 16이하이면 반드시 받는다.
 [GameFinish]
-[ ] 플레이어의 카드 합이 21을 초과하면 (딜러의 결과에 관계없이)패배한다.
-[ ] 딜러의 카드 합이 21을 초과하면 딜러가 패배한다.
-[ ] 카드의 합이 21을 초과하지 않은 모든 플레이어는 승리
 [GameResult]
-[ ] 
