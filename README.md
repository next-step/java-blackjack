# 연료 주입
## 기능 요구 사항
우리 회사는 렌터카를 운영하고 있다
현재 보유하고 있는 차량은 Sonata 2대, Avante 1대, K5 2대로 총 5대의 차량을 보유하고 있다. 
고객이 인터넷으로부터 예약할 때 여행할 목적지의 대략적인 이동거리를 입력 받는다. 
이 이동거리를 활용해 차량 별로 필요한 연료를 주입한다. 
차량 별로 주입해야 할 연료량을 확인할 수 있는 보고서를 생성해야 한다.

각 차량별 연비는 다음과 같다.
* Sonata : 10km/리터
* Avante : 15km/리터
* K5 : 13km/리터

## 기능 구현 사항
- [x] 자동차를 보유하는 렌터카 회사는 factory method를 사용해 생성한다. RentCompany#create()
- [x] 자동차 인스턴스를 생성할 시 이동할 거리를 인자로 받는다.
- [x] RentCar 추상 클래스는 필드에 대한 getter 메소드를 가지는 Car 인터페이스를 구현한다.
- [x] 렌터카 회사에 있는 자동차들은 RentCar 추상클래스를 상속받는다. RentCar - Sonata, Avante, K5

# 블랙잭
## 기능 요구 사항
블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.
카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.
딜러는 처음에 받은 2장의 합계가 16이하이면 반드시 1장의 카드를 추가로 받아야 하고, 17점 이상이면 추가로 받을 수 없다.
게임을 완료한 후 각 플레이어별로 승패를 출력한다.

## 기능 구현 사항
- [ ] 게임에 참여할 사람을 쉼표로 구분한다. - InputView
- [x] 카드는 숫자랑 문양으로 이루어진다. - Card
  - [x] 숫자와 문양은 Enum 형태로 관리한다.
  - [ ] Ace는 1또는 11로 계산할 수 있다.
  - [x] King, Queen, Jack은 각각 10으로 계산한다.
- [ ] 카드는 덱으로 관리한다. - CardDeck
  - [ ] 게임을 시작할 때 shuffle을 한 번 수행한다.
  - [ ] 카드는 문양 + 숫자 조합이 하나씩만 존재한다.
- [ ] 게임을 시작하면 딜러를 포함한 모든 플레이어들에게 카드를 2장씩 나누어준다.
  - [ ] 딜레를 제외한 플레이어는 21을 초과하지 않을 때까지 카드를 계속 받을지 선택한다.
  - [ ] 딜러는 처음 받은 카드 두 장의 합이 16이하면 한 장의 카드를 더 받는다.

