# java-blackjack

## 연료 주입
## 기능 요구 사항
    * 자동차 생성
        * 여행하려는 거리 가져오기
        * 리터당 이동 거리. 즉, 연비 가져오기
        * 차종의 이름 가져오기
        * 필요한 연료 계산
    * 렌트 회사 생성
        * 자동차 추가
        * 보고서 생성


## 블랙잭
## 기능 요구 사항

* 입력
    * 게임 참여자
    * 카드 받기

* 게임
    * 카드 나누어주기
    * 딜러가 부족한 카드 받기 

* 출력
    * 기존에 받았던 카드 출력
    * 카드 숫자 총합 결과 출력
    * 승패 출력
    

## 기능 구현

# View
            
# Controller

# Domain
    * Player
    * Dealer -> Player
    * Gamer -> Player
    * Gamers
    * enum Denomination
    * enum Suit
    * PlayingCard
    * Cards
    * Game { Dealer, Gamers }
    * GameResult

A2345678910JQK

```
게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)
pobi,jason

딜러와 pobi, jason에게 2장의 나누었습니다.
딜러: 3다이아몬드
pobi카드: 2하트, 8스페이드
jason카드: 7클로버, K스페이드

pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y
pobi카드: 2하트, 8스페이드, A클로버
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason은 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason카드: 7클로버, K스페이드

딜러는 16이하라 한장의 카드를 더 받았습니다.

딜러 카드: 3다이아몬드, 9클로버, 8다이아몬드 - 결과: 20
pobi카드: 2하트, 8스페이드, A클로버 - 결과: 21
jason카드: 7클로버, K스페이드 - 결과: 17

## 최종 승패
딜러: 1승 1패
pobi: 승 
jason: 패
```