## StepExecution

- `Step` 에 대한 한 번의 시도를 의미하는 객체 `Step` 실행 중에 발생한 정보들을 저정하고 있는 객체
  - 시작시간, 종료시간, 상태(시작됨, 완료, 실패), `commit`, `count`, `rollback`, `count` 등
- `Step` 이 매번 시도될 때마다 생성되며 각 Step 별로 생성된다.
- `Job` 이 **재시작 하더라도 이미 성공적으로 완료된 Step 은 재 실행되지 않고 실패한 Step 만 실행된다.**
- 이전 단계 Step 이 실패해서 현재 Step 을 실행하지 않았다면 `StepExecution` 을 생성하지 않는다. Step 이 실제로
시작됐을 때만 `StepExecution` 을 생성한다.

---

### JobExecution 과의 관계
- **Step 의 StepExecution 이 모두 정상적으로 완료 되어야 `JobExecution`이 정상적으로 완료**
- Step 의 StepExecution 중 하나라도 실패하면 `JobExecution` 은 실패

---

### BATCH_STEP_EXECUTION 테이블과 매핑
- `JobExecution` 과 `StepExecution` 는 1:M 의 관계
- 하나의 Job 에 여러 개의 Step 으로 구성했을 경우 각 StepExecution 은 하나의 JobExecution 을 부모로 가진다.

---
### StepExecution 도메인

![img_8.png](img_8.png)
[출처: 인프런 스프링 배치 강의 중](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B0%B0%EC%B9%98/dashboard)
