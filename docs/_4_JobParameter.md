## JobParameter

- Job 을 실행할 때 함께 포함되어 사용되는 파라미터를 가진 도메인 객체
- 하나의 Job 에 존재할 수 있는 여러개의 `JobInstance`를 구분하기 위한 용도
- JobParameter 와 JobInstance 는 1:1 관계
- `BATCH_JOB_EXECUTION_PARAM` 테이블과 매핑
