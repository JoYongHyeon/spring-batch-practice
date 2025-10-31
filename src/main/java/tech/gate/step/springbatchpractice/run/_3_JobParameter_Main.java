package tech.gate.step.springbatchpractice.run;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import tech.gate.step.springbatchpractice.SpringBatchPracticeApplication;

import java.util.Date;

public class _3_JobParameter_Main {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBatchPracticeApplication.class, args);

        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean("testJob_1", Job.class);

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("name", "user1")
                .addLong("id", 2L)
                .addDate("date", new Date())
                .addDouble("price", 100.0)
                .toJobParameters();

        jobLauncher.run(job, jobParameters);
        context.close();
    }
}
