package tech.gate.step.springbatchpractice.run;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import tech.gate.step.springbatchpractice.SpringBatchPracticeApplication;

public class _4_JobExecution {

    public static void main(String[] args) throws Exception {

        ConfigurableApplicationContext context
                = SpringApplication.run(SpringBatchPracticeApplication.class, args);

        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job failedJob = context.getBean("failedJob_1", Job.class);

        JobParameters jobParameters = new JobParametersBuilder().toJobParameters();
        jobLauncher.run(failedJob, jobParameters);
    }
}
