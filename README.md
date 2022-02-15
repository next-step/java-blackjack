# 연료 주입

## TDD 기능 구현 사항

- [x] Sonata
  - [x] `Sonata` String Type 이름을 가져야한다.
  - [x] `10km/리터`의 연비 가져야한다.
  - [x] 거리
    - [x] 거리를 가져야한다.
    - [x] 거리는 `0` 이상 정수이어야 한다.  
  - [x] 주입해야할 연료량을 구할 수 있다.
- [x] Avante
  - [x] `Avante` String Type 이름을 가져야한다.
  - [x] `15km/리터`의 연비 가져야한다.
  - [x] 거리 가져야한다.
    - [x] 거리는 `0` 이상 정수이어야한다.  - 
  - [x] 주입해야할 연료량을 구할 수 있다.
- [x] K5
  - [x] `K5` String Type 이름을 가져야한다.
  - [x] `13km/리터`의 연비 가져야한다.
  - [x] 거리 가져야한다.
    - [x] 거리는 `0` 이상 정수이어야한다.  
  - [x] 주입해야할 연료량을 구할 수 있다.
- [x] RentCompany
  - [x] `List<Car>`을 가져야한다.
  - [x] `List<Car>`에 대한 getter를 가져야한다.
  - [x] `create()`, 팩토리 메서드를 구현한다.
  - [x] `addCar()`, 차를 추가할 수 있다.
    - [x] `List<Car>`에 Sonata를 추가할 수 있다.
    - [x] `List<Car>`에 Avante를 추가할 수 있다.
    - [x] `List<Car>`에 K5를 추가할 수 있다.
  - [x] `generateReport()`는 전체 결과를 출력한다.
  
## 기능 구현 사항

- 보유 차량
  - Sonata 
    - 대수: 2대
    - 연비: 10km/리터 
  - Avante 
    - 대수: 1대
    - 연비: 15km/리터
  - K5 
    - 대수: 2대
    - 연비: 13km/리터
- 고객이 인터넷으로부터 예약할 때 여행할 목적지의 대략적인 이동거리를 입력 받을 수 있다.
- 이동거리를 활용해 차량 별로 필요한 연료를 주입할 수 있다.
- 차량 별로 주입해야 할 연료량을 확인할 수 있는 보고서를 생성할 수 있다.

## 프로그래밍 요구 사항

- [x] 상속과 추상 메서드를 활용한다.
- [x] 위 요구사항을 if/else 절을 쓰지 않고 구현해야 한다.
- [x] 인터페이스를 적용해 구현한다.

---

# java-blackjack

## TDD 기능 구현 사항

- [] User
  - [] Deck을 가지고 있다.
  - [] UserName을 가지고 있다.
  - [] Deck에 카드를 추가할 수 있다.
  - [] Deck의 현재 score가 21을 넘는지에 대한 boolean 계산을 할 수 있다. 
  - [] 해당 카드의 점수인 score를 계산 할 수 있다.
- [] Dealer
  - [] 총 score가 16이하일 경우, 1장의 카드를 추가로 받는다.
- [] Player
- [] Deck - 딜러 또는 플레이어가 가진 Card의 집합
  - [] List<Card>를 가지고 있다.
  - [] 현재 List<Card>의 총 score를 계산할 수 있다.
  - [] 현재 가진 Card 중에서 Ace가 있는 경우, 해당 Card에 대한 Score를 1 또는 11로 계산할 수 있다.
    - [] 21을 초과하지 않으면서, 21에 가깝게 계산할 수 있다.
- [x] Card - Game에서 사용할 카드의 객체
  - [x] CardType type을 가지고 있다. (e.g 다이아몬드, 클로버, 스페이드, 하트 ...)
  - [x] CardNumber _String을_ 가지고 있다. (e.g 2, 3, A, K, Q, J ...)
  - [x] 카드 숫자와 카드 타입을 입력할때, 주어진 숫자와 타입으로 카드가 생성된다.
- [x] CardType - Card의 타입
  - [x]  CardType은 `"다이아몬드", "하트", "클로버", "스페이드"` 이 범위안에 반드시 있어야한다.
- [x] CardNumber - Card의 숫자
  - [x]  CardNumber는 `"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"` 이 범위안에 반드시 있어야한다.
- [] GameCard - 게임에서 사용될 모든 Card의 집합
  - [] 모든 Card는 중복이 없어야한다.
- [] GameUser - BlackJack을 수행한는 User의 집합
  - [] List<User>를 가지고 있다.
  - [] User를 추가할 수 있다.
  - [] List<User>를 반환할 수 있다.
- [] BlackJack - 게임 로직 수행
  - [] GameUser를 가지고 있다.
  - [] GameCard를 가지고 있다.
  - [] 게임 진행시 최초로 GameCard를 셔플할 수 있다.
  - [] User별로 턴을 진행할 수 있게 한다.
  - [] GameCard에서 Card를 하나 뽑을 수 있다.
  - [] User에 카드를 전달할 수 있다.
  - [] 21을 넘지 않는 경우, User에게 카드를 지속적으로 전달할 수 있다.
- [] UserStats - User별 승/패에 대한 정보
  - [] GameUser를 인자로 받아 User별, 승/패 정보를 계산한다.
- [] GameController - 전체적인 게임을 진행할 Controller 
  - [] 이름의 배열을 BlackJack에 전달한다.
- [] UserName - 게임 참여자의 이름
- [] InputParser - String -> List<String>의 이름의 배열로 반환한다.
  - [] 이름의 중복을 확인한다.
  - [] 이름의 공백을 확인한다.
- [] InputView
  - [] 게임에 참여할 이름을 입력받는다.
- [] OutputView

## 최초 PR 마감 기한

2월 17일 목요일까지


### git pull pair

```bash
git pull pair step1
```

### git multiple author

```bash
git commit -m "commit message


Co-authored-by: hochan222 <hochan049@gmail.com>
Co-authored-by: chanuuuuu <dn0208@gmail.com>
```
