# java-lotto-precourse

# 로또

## 기능 목록

- [x] 금액 입력
- [x] 당첨 번호 입력
- [x] 로또 구매수량 및 번호 출력
- [x] 당첨 내역 출력
- [x] 수익률 출력
- [x] 로또 번호 기능
- [x] 보너스 번호 처리 기능
- [x] 로또 번호 정렬 기능
- [x] 당첨 번호와 로또 번호 확인 기능
- [x] 로또 게임 기능
- [x] 로또 객체 조립 기능
- [x] 당첨 기능
- [x] 수익률 기능
- [x] 에러 메세지 객체
- [x] 난수 기능
- [x] 1000원 단위 금액 계산 기능
- [x] 로또 당첨 판단 기능

## 예외 처리

- [x] 금액 오버 플로우
- [x] 1000원 단위 안 떨어질 경우 예외 처리
- [x] 금액 입력 음수, 0 예외처리
- [x] 숫자만 입력 가능 하도록 예외처리

## 리펙터링

- [x] for문을 stream으로 전환
- [x] inputview 클래스 파싱 부분 클래스로 나누고 책임 분리
- [x] outputview 클래스 lottosview 메서드를 3가지 메서드로 책임 분리
- [x] errormessage들을 enum으로 정리
- [x] factory 기능을 한가지만 하도록 변경 외부값 몰라도 되게
- [x] controller 의 run 메서드를 3가지 메서드로 분리
- [x] 메서드명들 명확하게 변경

## 패키지 구조
```
lotto
├── Application.java # 프로그램 진입점
├── config
│ └── AppConfig.java # 의존성 설정
├── controller
│ └── LottoController.java # 전체 흐름 제어
├── service
│ ├── LottoService.java # 인터페이스
│ └── LottoServiceImpl.java # 비즈니스 로직 (로또 생성)
├── domain
│ ├── Lotto.java # 로또 객체 (6개 번호)
│ ├── Lottos.java # 로또 목록 관리 (당첨 계산)
│ ├── LottoAmount.java # 구매 금액 (검증)
│ ├── LottoRule.java # 당첨 규칙 (등수별 상금)
│ └── RandomNumber.java # 랜덤 번호 생성
├── factory
│ └── LottoFactory.java # 로또 생성
├── parse
│ └── InputParse.java # 입력값 파싱 및 검증
├── message
│ └── ErrorMessage.java # 에러 메시지 관리
└── view
├── InputView.java # 사용자 입력
└── OutputView.java # 결과 출력