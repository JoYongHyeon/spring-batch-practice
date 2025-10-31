package tech.gate.step.springbatchpractice.run;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import tech.gate.step.springbatchpractice.SpringBatchPracticeApplication;

public class _1_RunJob_Main {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBatchPracticeApplication.class, args);

        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean("testJob_1", Job.class);

        // 중복 실행 방지를 위한 Unique Parameter 추가
        JobParameters params = new JobParametersBuilder()
                .addLong("timestamp", System.currentTimeMillis())
                .toJobParameters();

        System.out.println(">>> testJob 실행 시작 <<<");
        jobLauncher.run(job, params);
        System.out.println(">>> testJob 실행 완료 <<<");

        context.close();
    }
}
