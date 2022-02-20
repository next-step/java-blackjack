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

[Card : Denomination, Shape]

- [x] enum으로 1~10,J,Q,K를 구현한다.
- [x] enum으로 하트,스페이드,다이아몬드,클로버를 구현한다.
- [x] value와 shape를 합쳐 한 장의 카드를 생성한다.

[Person]

- [x] 모든 사람들은 카드 목록을 갖고 있다.
- [x] 카드 1장을 인자로 전달 받아 카드 목록에 추가한다.

[Player extends Person]

- [x] 플레이어는 추가적으로 이름을 갖고 있다.
- [x] 생성 시에 플레이어 이름만 인자로 전달 받아서 자기의 이름을 초기화한다.
- [x] 전달 받은 1장의 카드를 자신의 카드 목록에 추가한다. (Person 기능)

[Dealer extends Person]
딜러가 카드를 섞어서 뽑는 역할. CardDeck으로 분리.

- [x] 생성 시에 CardDeck을 초기화한다.
- [x] 인자로 전달 받은 1장의 카드를 자신의 카드 목록에 추가한다. (Person 기능)
- [x] 전달 인자로 받은 장수만큼 카드를 반환한다.

[CardDeck]

- [x] 전체 카드를 만들어서 리스트로 반환한다. (static)
- [x] 인스턴스 생성 시, 만들어진 52장의 카드로 멤버변수를 초기화한다.
- [x] shuffle한 뒤 전달인자로 받은 수만큼 카드를 뽑아서 반환한다. (제거하면서 반환한다.)

[GameApplication]

- [x] GameSetup의 Dealer와 List<Player>를 입력받고, 생성된 setup 내용을 ResultView에게 넘긴다.

- [ ] 카드의 합이 21 이하인지 카드를 추가로 뽑을 것인지 질문한다.
- [ ] 딜러에게 필요한 장수만큼 카드를 요구한다.
- [ ] 반환 받은 카드를 통해 딜러와 플레이어들을 초기화한다.

[InputView]

-[x] 플레이어 이름을 입력받아서 쉼표 기준으로 분리한 List<String>을 반환한다.
-[x] 플레이어에게 카드를 추가로 받을 것인지 입력받는다.

[ResultView]

-[x] 딜러와 플레이어 List<>를 전달 받아 이름과 카드 목록을 출력한다.
    -[x] 처음 시작 때 딜러는 1장의 카드만 출력한다.
-[ ] 딜러와 플레이어의 최종 승패를 출력한다.
