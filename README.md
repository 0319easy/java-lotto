# 1단계 - 학습 테스트 실습
## String 클래스에 대한 학습 테스트
### 요구사항
1. split
2. substring
3. charAt

## Set Collection에 대한 학습 테스트
### 요구사항
1. size 확인
2. contains 확인


# 2단계 - 문자열 덧셈 계산기
### 요구사항
1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
2. 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
3. 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

### 실행예시
```
계산할 문자열을 입력해주세요.
1,2:3,3:10
19
```

# 3단계 - 로또(자동)
### 요구사항
1. 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
2. 로또 1장의 가격은 1000원이다.

### 진행방법
1. 구입 금액 입력
2. 금액에 따른 개수만큼 로또 할당
3. 지난 주 당첨 번호 입력
4. 당첨 통계 확인

### 기능목록
* 입력
    1. 구입 금액 입력
    2. 지난 주 당첨 번호
* 출력
    1. 구매 갯수
    2. 당첨 통계
* 핵심 기능
    1. 로또 발급
    2. 당첨 확인
    3. 당첨 통계 계산

### 실행예시
```
구입금액을 입력해 주세요.
10000
10개를 구매했습니다.
[3, 15, 20, 23, 26, 28]
[21, 22, 30, 31, 40, 45]
[15, 22, 26, 35, 40, 45]
[4, 13, 31, 34, 40, 41]
[4, 5, 15, 16, 28, 30]
[7, 8, 24, 41, 42, 43]
[4, 32, 34, 36, 37, 41]
[7, 11, 13, 28, 32, 35]
[6, 13, 14, 15, 20, 23]
[2, 11, 21, 22, 25, 43]

지난 주 당첨 번호를 입력해 주세요.
1,2,3,11,21,5

당첨 통계
---------
3개 일치 (5000)-1개
4개 일치 (50000)-0개
5개 일치 (1500000)-0개
6개 일치 (2000000000)-0개
총 수익률은 0.5입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

# 4단계 - 로또(2등)

# 디렉토리 구조
```
└─src
    ├─main
    │  └─java
    │      ├─lotto                                 로또 게임
    │      │  │  LottoGameApp.java                 게임 애플리케이션
    │      │  │
    │      │  ├─common
    │      │  │      ErrorCode.java                공통 에러 코드
    │      │  │      WinningType.java              당첨 타입
    │      │  │
    │      │  ├─domain
    │      │  │      LottoNumber.java              로또 번호
    │      │  │      LottoTicket.java              로또 티켓
    │      │  │      LottoTicketGenerator.java     로또 티켓 생성기
    │      │  │      Money.java                    지불 돈
    │      │  │      ProfitCalculator.java         수익률 계산기
    │      │  │      WinningNumbers.java           당첨 번호
    │      │  │
    │      │  └─view
    │      │          GameView.java                게임 화면
    │      │          InputView.java               입력 화면
    │      │          ResultView.java              결과 화면
    │      │
    │      └─step2                                  2단계 - 문자열 덧셈 계산기
    │              Numbers.java
    │              StringAddCalculator.java
    │              StringAddCalculatorApp.java
    │
    └─test
        └─java
            ├─lotto
            │  └─domain
            │          LottoNumberTest.java
            │          LottoTicketGeneratorTest.java
            │          LottoTicketTest.java
            │          MoneyTest.java
            │          ProfitCalculatorTest.java
            │          WinningNumbersTest.java
            │
            ├─step1                                  1단계 - 학습 테스트 실습
            │      SetTest.java
            │      StringTest.java
            │
            └─step2
                    NumbersTest.java
                    StringAddCalculatorTest.java

```
