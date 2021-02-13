# java-blackjack

# 연료 주입

클래스
 - RentCompany ( 렌터차량 추가 메서드(addCar(new Car(여행거리)) ) )
 - ??? RentCarFactory ( 렌터차량 팬터리 클래 )

 - Car ( 리터당거리(연비)/여행거리/차종 을 반환하는 추상메서드 + 여행거리를 위해 연료량(거리/연비) 계산하는 메서드 )
  - K5
  - Avante
  - Sonata

## 기능 목록
- 
- 차량등록 (생성자)
- 여행 거리 입력
- 주입 연료량 계산 
- 리포트 출력


# 블랙잭

## 기능 목록
- 참여자 정보 저장하기
- 덱 섞기
- 초기 패 2장 나눠주기
- 패  장씩 나눠주기
- 패를 새로 받을 지 결정하기 - input 에 따라 (플레이어 마다 반복 및 종료)
- 딜러가 한 장 더 받아야 할 지(처음 두 장 합이 16이하일 떄)
- 딜러와 플레이어들의 패 출력하기
- 최종 승패 출력하기

## 픽스해야할 룰, 규칙
- 처음 패를 나눌때 2장을 한번에 줄 것인지

## 필요한 클래스 구조
- Domain
    - Human(CardChunk, name, Abstract - GetCard )
        - Player(GetCard 구현, hit, stand)
        - Dealer(GetCard 구현(딜러의 카드 지급 조건) )
    - Card(숫자, 모양)
    - CardChunk(플레이어가 들고 있는 카드들)
    - Deck(Card들을 갖고 있는 컨테이너(?))
    - Awards(딜러와 플레이어의 승패 저장?!)
- Controller
    - BlackJack ( 게임 진행 - Domain <-> View 간 데이터 이동 포함 )
- View
    - InputView (입력 받음 - system.in)
    - OutputView (출력함 - system.out)

스탠드 Stand/"No More" 더이상 카드를 받지 않음
히트 Hit 카드를 한 장 더 받음. 버스트 될 때까지 여러 번 히트 가능.
버스트 Bust 총합 21 초과.   ( 플레이어가 버스트 됐을 경우 딜러는 모든 베팅 금액을 가져가고 다음 플레이어 차례로 넘어갑니다. 딜러가 버스트 되면 자동적으로 버스트 되지 않은 플레이어의 승리입니다. )
BlackJack 21

