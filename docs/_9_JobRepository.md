## JobRepository

- 배치 작업 중의 정보를 저장하는 저장소 역할
- `Job` 이 언제 수행되었고, 언제 끝났으며, 몇 번이 실행되었고 실행에 대한 `결과` 등의 배치 작업의 수행과 관련된
모든 `meta data`를 저장
  - `JobLauncher`, `Job`, `Step` 구현체 내부에서 `CRUD` 기능을 처리한다.
   
![img_5.png](img_5.png)
[출처: 인프런 스프링 배치 강의 중](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B0%B0%EC%B9%98/dashboard)
