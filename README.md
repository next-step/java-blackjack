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
- [ ] RentCompany
  - [ ] `create()`, 팩토리 메서드를 구현한다.
  - [ ] `addCar()`, 차를 추가할 수 있다.
  - [ ] `generateReport()`는 전체 결과를 출력한다.
- [ ] InputView
  - [ ] 이동거리와 차를 입력 받을 수 있다.
- [ ] OutputView
  - [ ] `printRequiredFuel()` 하나의 차에 대해 연비를 출력할 수 있다.
  
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

- [ ] 상속과 추상 메서드를 활용한다.
- [ ] 위 요구사항을 if/else 절을 쓰지 않고 구현해야 한다.
- [ ] 인터페이스를 적용해 구현한다.

# java-blackjack

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
