package tech.gate.step.springbatchpractice.run;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import tech.gate.step.springbatchpractice.SpringBatchPracticeApplication;

public class _8_RunJob_Main {

    public static void main(String[] args) throws Exception {

        ConfigurableApplicationContext context = SpringApplication.run(SpringBatchPracticeApplication.class, args);

        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean("testJob_8", Job.class);

        JobParameters params = new JobParametersBuilder()
                .addString("jobName", "testJob_8")
                .toJobParameters();

        System.out.println("==================== testJob_8 실행 시작 ====================");
        jobLauncher.run(job, params);
        System.out.println("==================== testJob_8 실행 완료 ====================");

        context.close();
    }
}
