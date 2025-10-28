### Spring Batch 5.x 의 구조적 변화
1. 가장 큰 차이는 Spring Batch 4.X (Spring Boot 2.x) 까지는
`@EnableBatchProcessing` 가 필수적으로, 이 어노테이션이 자동으로
`JobRepository`, `JobLauncher`, `JobExplorer`, `JobBuilderFactory`, `StepBuilderFactory`
등을 만들어줬음.
2. Spring Batch 5.X (Spring Boot 3.x) 부터는 구조적으로 바뀜
`@EnableBatchProcessing` 을 붙이면 Spring Boot 의 자동 구성(`BatchAutoConfiguration`) 과 충돌 <br>
-> 허탈하다..

### 요약
- `@EnableBatchProcessing` 은 더 이상 필요하지 않음
- `spring-boot-starter-batch` 의존성을 추가하면 Boot 가 자동으로 Batch 환경 구성함(신경쓸게 더 없어짐)
- Boot 는 `DataSource` 가 존재하면 알아서 `JobRepository`, `JobLauncher`, `JobExplorer` 를 Bean 으로 등록하는 듯
- 만약 직접 커스터마이징이 필요하면 `BatchConfiguration` 클래스를 만들어 `@Configuration` 으로 선언해야함.
- (https://docs.spring.io/spring-batch/reference/whatsnew.html#spring-boot-integration-changes) 잘 설명되어있음...

