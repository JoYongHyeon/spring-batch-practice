package tech.gate.step.springbatchpractice.config.job;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import tech.gate.step.springbatchpractice.config.tasklet.*;

@Configuration
@RequiredArgsConstructor
public class _8_Job_Config {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    @Bean
    public _8_1_tasklet _8_1_tasklet() {
        return new _8_1_tasklet();
    }

    @Bean
    public _8_2_tasklet _8_2_tasklet() {
        return new _8_2_tasklet();
    }

    @Bean
    public _8_3_tasklet _8_3_tasklet() {
        return new _8_3_tasklet();
    }

    @Bean
    public _8_4_tasklet _8_4_tasklet() {
        return new _8_4_tasklet();
    }

    @Bean
    public Job testJob_8() {
        return new JobBuilder("testJob_8", jobRepository)
                .start(testStep8_1())
                .next(testStep8_2())
                .next(testStep8_3())
                .next(testStep8_4())
                .build();
    }

    @Bean
    public Step testStep8_1() {
        return new StepBuilder("testStep_8_1", jobRepository)
                .tasklet(_8_1_tasklet(), transactionManager)
                .build();
    }

    @Bean
    public Step testStep8_2() {
        return new StepBuilder("testStep_8_2", jobRepository)
                .tasklet(_8_2_tasklet(), transactionManager)
                .build();
    }

    @Bean
    public Step testStep8_3() {
        return new StepBuilder("testStep_8_3", jobRepository)
                .tasklet(_8_3_tasklet(), transactionManager)
                .build();
    }

    @Bean
    public Step testStep8_4() {
        return new StepBuilder("testStep_8_4", jobRepository)
                .tasklet(_8_4_tasklet(), transactionManager)
                .build();
    }

}
