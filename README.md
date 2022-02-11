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
