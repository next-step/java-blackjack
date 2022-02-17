# java-blackjack

# 📌 연료 주입

## 기능 요구 사항

우리 회사는 렌터카를 운영하고 있다.

현재 보유하고 있는 차량은 Sonata 2대, Avante 1대, K5 2대로 총 5대의 차량을 보유하고 있다.

고객이 인터넷으로부터 예약할 때 여행할 목적지의 대략적인 이동거리를 입력 받는다.

이 이동거리를 활용해 차량 별로 필요한 연료를 주입한다. 차량 별로 주입해야 할 연료량을 확인할 수 있는 보고서를 생성해야 한다.

```
* Sonata : 10km/리터
* Avante : 15km/리터
* K5 : 13km/리터
```

## 프로그래밍 요구 사항

- 상속과 추상 메서드를 활용한다.
- 위 요구사항을 `if/else` 절을 쓰지 않고 구현해야 한다.

## 기능 구현 사항

- [x] `Car` 클래스 추상화 (`Car`)
    - [x] 주입해야할 연료량 계산 (`Car.getChargeQuantity()`)
- [x] 파생 클래스 구현

    - [x] `Sonata` 클래스 구현 (`Sonata`)
        - [x] 리터당 이동 거리 계산 (`Sonata.getDistancePerLiter()`)
        - [x] 여행하려는 거리 반환 (`Sonata.getTripDistance()`)
        - [x] 차종의 이름 반환 (`Sonata.getName()`)

    - [x] `Avante` 클래스 구현 (`Avante`)
        - [x] 리터당 이동 거리 계산 (`Avante.getDistancePerLiter()`)
        - [x] 여행하려는 거리 반환 (`Avante.getTripDistance()`)
        - [x] 차종의 이름 반환 (`Avante.getName()`)

    - [x] `K5` 클래스 구현 (`K5`)
        - [x] 리터당 이동 거리 계산 (`K5.getDistancePerLiter()`)
        - [x] 여행하려는 거리 반환 (`K5.getTripDistance()`)
        - [x] 차종의 이름 반환 (`K5.getName()`)

---

# 📌 블랙잭

# 기능 요구 사항

블랙잭 게임을 변형한 프로그램을 구현한다. 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.

- 카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
- 게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면
  얼마든지 카드를 계속 뽑을 수 있다.
- 딜러는 처음에 받은 2장의 합계가 16이하이면 반드시 1장의 카드를 추가로 받아야 하고, 17점 이상이면 추가로 받을 수 없다.
- 게임을 완료한 후 각 플레이어별로 승패를 출력한다.

## 프로그래밍 요구 사항

- 모든 엔티티를 작게 유지한다.
- 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
- 딜러와 플레이어에서 발생하는 중복 코드를 제거해야 한다.

## 기능 구현 사항

- [x] 사람 이름 입력받기(`InputView.getPlayerNames`)
- [x] 카드는 문양값(`Suit`)과 숫자값(`Denomination`)을 가진다 (Card)
    - [x] 문양값(`Suit`)과 숫자값(`Denomination`)은 `enum`으로 구현한다
- [x] 카드리스트를 가진 일급 컬렉션 Deck 구현
    - [x] 카드를 생성한다 (`Deck.setupCard()`)
    - [x] 카드를 섞는다 (`Deck.shuffle()`)
    - [x] 카드 한 장을 꺼낸다 (`Deck.popCard()`)
- [x] `Dealer`는 `Player` 클래스로부터 상속을 받는다
- [x] 카드 숫자를 계산한다 (`Player.calculateScore()`)
- [x] 딜러가 플레이어에게 카드 배분한다 (`Dealer.allocateCard()`)
- [x] 딜러의 처음 받은 2장의 카드 합계가 16이하라면 카드 한 장을 추가로 받는다 (`Dealer.addOneMoreCard`)
- [x] 카드 추가 여부 묻기 (`InputView.askAddCard()`)
- [x] 우승자를 찾는다 (`Judgement.findWinner()`)
- [x] 최종 승패 계산하기 (`Judgement.judgeResult()`)
