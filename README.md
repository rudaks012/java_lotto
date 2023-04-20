# 2주차 단위 테스트 

### 기능요구사항
### Input
- [ ] 로또 구입 금액 입력 한다. (Input#enterAmount)
- [ ] 지난 주 당첨 번호를 입력 한다. (Input#enterLastWeekLotto)

### Output
- [ ] 구입한 로또의 수량을 출력한다. (Output#printLottoCount)
- [ ] 구입한 로또의 출력한다. (Output#printLotto)
- [ ] 3~6개 까지의 일치한 로또 수를 출력한다. (Output#printLottoStatistics)
- [ ] 총 수익률을 출력한다. (Output#printProfit)

### Amount
- [ ] 로또 한장의 금액은 천원이다. (Amount.lottoOneAmount)
- [ ] 구매 가능한 로또의 개수를 알려준다. (Amount#informLottoCount)

### LottoPaper
- [ ] 수량 만큼 로또를 생성한다. (LottoPaper#createLotto)

### Number
- [ ] 로또의 1~45의 숫자이다. (Number#validateBound)

### Lotto
- [ ] 로또는 중복되지 않은 6개의 숫자로 구성되어 있다. (Lotto.consistsNumbers)
- [ ] 로또는 6개의 숫자를 무작위로 생성된다. (Lotto#createLottoNumber)

### Statistics
- [ ] 3~6개 까지의 일치하는 로또의 수를 찾는다. (Statistics#findMatchingLottoNumber)

### Profit
- [ ] 수익률을 계산한다. (당첨 금액 / 구입 금액) (Profit#calculate)

### 프로그래밍 요구사항
1. TDD
2. MVC
3. indent 1까지 허용
4. 메서드 길이 최대 15라인
5. 모든 로직 단위테스트
6. 코드 컨벤션 준수
7. else 예약어를 쓰지 않는다.
8. switch , case 금지
