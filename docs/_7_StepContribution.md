## StepContribution

- 청크 프로세스의 변경 사항을 버퍼링 한 후 `StepExecution` 상태를 업데이트하는 도메인 객체
- 청크 커밋 직전에 `StepExecution` 의 `apply` 메서드를 호출하여 상태를 업데이트 함
- `ExitStatus` 의 기본 종료코드 외 사용자 정의 종료코드를 생성해서 적용 할 수 있다.

---

### 구조
`readCount` : 성공적으로 read 한 아이템 수 <br>
`writeCount` : 성공적으로 write 한 아이템 수 <br>
`filterCount` : ItemProcessor 에 의해 필터링된 아이템 수 <br>
`parentSkipCount` : 부모 클래스인 StepExecution 의 총 skip 횟수
`readSkipCount` : read 에 실패해서 스킵된 횟수 <br>
`writeSkipCount` : write에 실패해서 스킵된 횟수 <br>
`processSkipCount` : process에 실패해서 스킵된 횟수 <br>
`ExitStatus` : 실행결과를 나타내는 클래스로서 종료코드를 포함(`UNKNOWN`, `EXECUTING`, `COMPLETED`, `NOOP`, `FAILED`, `STOPPED`) <br>
`stepExecution` : StepExecution 객체 저장

![img_11.png](img_11.png)

`StepContribution` 을 열어보면 `StepExecution` 을 참조하는 구조로
**실시간 카운팅 및 상태 전달용** 정도라고 생각하면 될듯.

---

### 정리

`StepExecution`
- **step 전체 단위** 의 실행 상태를 담는 메타데이터 객체
- 예: startTime, endTime, status, exitStatus, commitCount, readCount
- DB(BATCH_STEP_EXECUTION 테이블)에 기록되는 최종 결과
즉, 스텝 전체 단위의 실행 결과를 요약한 객체


`StepContribution`
- **Chunk 단위** 로 변경되는 읽기/쓰기/스킵 카운트를 가지고 있음
- `Tasklet` 이나 `ItemReader`/`Processor`/`Writer` 같은 컴포넌트가 실행되며 변경되는 카누트를 `StepExecution` 에 반영하는 중간 객체?
-  역할
  - `readCount` 증가
  - `wrtierCount` 증가
  - `filterCount` 증가
  - `skipCount` 증가
  -  -> 이런 변경 사항을 `StepExecution` 에 누적 하는 구조

즉, `StepExecution` 의 실시간 카운터 업데이트를 담당하는 객체
