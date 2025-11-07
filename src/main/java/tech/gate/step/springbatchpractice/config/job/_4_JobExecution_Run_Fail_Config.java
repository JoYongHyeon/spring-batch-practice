package tech.gate.step.springbatchpractice.config.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class _4_JobExecution_Run_Fail_Config {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    @Bean
    public Job failedJob_1() {
        return new JobBuilder("failedJob_1", jobRepository)
                .start(failedStep_1())
                .build();
    }

    @Bean
    public Step failedStep_1() {
        return new StepBuilder("failedStep_1", jobRepository)
                .tasklet(failed_tasklet_1(), transactionManager)
                .build();
    }

    @Bean
    public Tasklet failed_tasklet_1() {
        return (contribution, chunkContext) -> {
//            System.out.println("STEP 실행 중.... (의도적 실패)");
//            throw new RuntimeException("BATCH_JOB_EXECUTION 실패 코드 확인");
            return null;
        };
    }
}
