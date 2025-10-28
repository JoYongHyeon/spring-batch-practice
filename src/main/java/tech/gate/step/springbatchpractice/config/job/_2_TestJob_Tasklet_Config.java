package tech.gate.step.springbatchpractice.config.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class _2_TestJob_Tasklet_Config {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;


    @Bean
    public Job testJob_2() {
        return new JobBuilder("testJob_2", jobRepository)
                .start(testStep_2())
                .next(testStep_3())
                .build();
    }

    @Bean
    public Step testStep_2() {
        return new StepBuilder("testStep_2", jobRepository)
                .tasklet(step1Tasklet(), transactionManager)
                .build();
    }

    @Bean
    public Step testStep_3() {
        return new StepBuilder("testStep_3", jobRepository)
                .tasklet(step2Tasklet(), transactionManager)
                .build();
    }

    @Bean
    public Tasklet step1Tasklet() {
        return ((contribution, chunkContext) -> {
            System.out.println("======= call step1Tasklet =======");
            return RepeatStatus.FINISHED;
        });
    }

    @Bean
    public Tasklet step2Tasklet() {
        return ((contribution, chunkContext) -> {
            System.out.println("======= call step2Tasklet =======");
            return RepeatStatus.FINISHED;
        });
    }
}
