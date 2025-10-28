## Job
- 배치 계층 구조에서 가장 상위에 있느 개념 -> 하나의 배치 작업 자체를 의미
  - "계약 정보를 주기적으로 정산하는 배치?" 정도의 개념
- `Job Configuration` 을 통해 생성되는 객체 단위로서 배치작업을 어떻게 구성하고 실행할 것인지 전체적으로 설정하고 명세하는 것
- 배치 Job 을 구성하기 위한 최상위 인터페이스로 스프링 배치가 기본 구현체를 제공
- 여러 `Step` 을 포함하고 있고 반드시 한개 이상의 `Step` 이 필요함

### 기본 구현체
- `SimpleJob`
  - 순차적으로 `Step` 을 실행시키는 Job
  - 모든 Job 에서 사용할 수 있는 표준 기능
- `FlowJob`
  - 특정한 조건과 흐름에 따라 `Step` 을 구성하여 실행시키는 Job
  - `Flow` 객체를 실행시켜서 작업을 진행함



---

## JobInstance

---

## JobParameters

---

## JobExecution

---

## 대략적인 스프링 배치 도메인 흐름
`JobParameters` -> `JobLauncher` -> `Job->execute()->Steps` -> `SimpleJob, FlowJob` <- `AbstractJob` <- `Job` 
