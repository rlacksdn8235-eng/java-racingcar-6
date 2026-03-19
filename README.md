1. 자동차 이름 입력하는 기능 (쉼표로 이름을 구분가능 5자 이하)
2. 몇번 시도할지 입력하는 기능
3. 반복해서 시도하는 기능
   - 전진하는 조건은 0~9 사이에서 4 이상일 경우 (50%)
4. 실행결과 알려주는 기능
5. 우승자를 알려주는 기능(여러명일 경우 쉼표로 구분)
6. 잘못된 값 입력시 IllegalArgumentException 발동후 종료하는 기능
   - 이름 입력시 5자 이상, 빈값, 중복이름, 차가 두대 이상인지
   - 시도할 회수 입력시 숫자, 0보다 큰지 

---

게임
- 몇번 시도할지 입력하는 기능
- n대의 자동차 입력하는 기능
- 
자동차
- 전진할지 말지 판단하는 기능 (50% 0~9 4이상)
- 현재 상태를 출력하는 기능
- 
자동차들
- 입력받은 자동차 목록에서 이름 추출 후 자동차 생성하는 기능
- 우승자 출력하는 기능


--- 
# 리팩토링

게임을 진행 시켜라 > Game
  - 자동차 이름 입력해라 > CarNameScanner
    - 이름 문제없는지 확인해라 > CarNameValidator
    - 이름으로 자동차 생성해라 > CarFactory (Car의 Creator)
  - 레이싱 몇번할지 입력해라 > RepeatCountScanner
    - 시도횟수 문제없는지 확인해라 > RepeatCountValidator 
    - 레이싱 반복시켜라 > Race
      - 모든 자동차를 전진시켜라 > Cars
        - 전진시켜라(전진 가능한 상태인가 묻지말고 행동해라) > Car
      - 실행 결과를 출력해라 > ResultPrinter
  - 우승자를 출력해라 > WinnerPrinter
    - 우승자를 찾아라 > Cars
      - 가장 멀리간 위치를 찾아라 > Cars
      - 가장 멀리간 위치에 있는 자동차를 찾아라 > Car

Scanner Interface > scan > 명령
- CarNameScanner
- RepeatCountScanner
Validator Interface > validate > 명령
- CarNameValidator
- RepeatCountValidator
Printer Interface > print > 쿼리
- ResultPrinter
- WinnerPrinter
Car
- move > 명령
- findCarBySamePosition > 쿼리
Cars
- moveCars > 명령
- findWinners > 쿼리
- findCarByMaxPosition > 쿼리
CarFactory
- createCar > 명령
Game
- play > 명령
Race
- racing > 명령

## 문제점
Scanner들이 너무 많은 책임을 지고있음
입력 전문간데 자동차생성, 검증, 레이스 반복까지 하는중

Game, Race, Scanner 바꿔야함
Validator 같은 경우 동일한곳에서 사용하는게 아닌 다른곳에서 사용중이어서
굳이 다형성 유지 안하고 인터페이스 삭제 후 따로 의존성 주입

게임을 진행 시켜라
- 자동차 이름 입력해라
  - 이름 입력해라 
  - 검증해라
- 자동차 생성해라
- 레이싱 몇번할지 입력해라
- 시도횟수 문제없는지 확인해라
    - 이름 입력해라
    - 검증해라
- 레이싱 반복시켜라
    - 모든 자동차를 전진시켜라
        - 전진시켜라(전진 가능한 상태인가 묻지말고 행동해라)
    - 실행 결과를 출력해라
- 우승자를 출력해라
    - 우승자를 찾아라
        - 가장 멀리간 위치를 찾아라
        - 가장 멀리간 위치에 있는 자동차를 찾아라
    - 출력해라



