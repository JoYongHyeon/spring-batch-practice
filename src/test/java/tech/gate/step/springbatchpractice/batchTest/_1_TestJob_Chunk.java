package tech.gate.step.springbatchpractice.batchTest;


import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class _1_TestJob_Chunk {

    @Autowired
    JobLauncher jobLauncher;
    @Autowired
    Job testJob_1;

    @Test
    void runJob() throws Exception{
        JobParameters params = new JobParametersBuilder()
                .addLong("timestamp", System.currentTimeMillis())
                .toJobParameters();

        System.out.println(">>> 배치 테스트 실행 시작 <<<");
        jobLauncher.run(testJob_1, params);
        System.out.println(">>> 배치 테스트 실행 완료 <<<");
    }
}
