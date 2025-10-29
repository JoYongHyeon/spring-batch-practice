package tech.gate.step.springbatchpractice.run;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import tech.gate.step.springbatchpractice.SpringBatchPracticeApplication;

public class _2_BadJob_Main {

    public static void main(String[] args) throws Exception {

        ConfigurableApplicationContext context = SpringApplication.run(SpringBatchPracticeApplication.class, args);

        JobLauncher jobLauncher = context.getBean(JobLauncher.class);

        Job job = context.getBean("testJob_2", Job.class);

        /**
         * "이미 완료된 JobInstance 가 있다" 는 이유로 다시 실행을 막음
         * (JobInstanceAlreadyCompleteException)
         */
        JobParameters params = new JobParametersBuilder()
                .addString("name", "data1")
                .toJobParameters();

        System.out.println(">>> testJob 실행 시작 <<<");
        jobLauncher.run(job, params);
        System.out.println(">>> testJob 실행 완료 <<<");

        context.close();
    }
}
