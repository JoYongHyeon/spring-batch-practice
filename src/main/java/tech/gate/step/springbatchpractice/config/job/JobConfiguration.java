package tech.gate.step.springbatchpractice.config.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class JobConfiguration {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;


    /**
     * Chunk 기반 Job
     * - 읽고(Reader), 계산하고(Processor), 저장(Writer)하는 구조
     * - 대량 데이터 정산/집계 업무에는 Chunk 기반 Job 을 쓰지 않을까.?
     */
    @Bean
    public Job testJob() {
        return new JobBuilder("testJob", jobRepository)
                .start(testStep()) // Chunk 기반 Step 실행
                .build();
    }

    /**
     * Step 구성
     * - Chunk 단위로 트랜잭션 커밋 (ex. 10건마다 DB Commit)
     * - Reader → Processor → Writer 순서로 실행
     */
    @Bean
    public Step testStep() {
        return new StepBuilder("testStep", jobRepository)
                .<String, String>chunk(10, transactionManager)
                .reader(sampleReader())
                .processor(sampleProcessor())
                .writer(sampleWriter())
                .build();
    }

    /**
     * Reader: 데이터를 읽어오는 역할
     * - 실제로는 DB, CSV, API 등에서 데이터를 가져오는 곳인듯?
     */
    @Bean
    public ItemReader<String> sampleReader() {
        return new ItemReader<>() {

            private int count = 0;
            private final String[] data = {"계약1", "계약2", "계약3", "계약4", "계약5"};

            @Override
            public String read() {
                return count < data.length ? data[count++] : null;
            }
        };
    }

    /**
     * Processor: 읽은 데이터를 가공 및 처리 하는 단계?
     */
    @Bean
    public ItemProcessor<String, String> sampleProcessor() {
        return item -> item + " -> 정산 처리 완료";
    }

    /**
     * Writer: 처리된 결과를 저장
     * - DB,파일 기록, 외부 전송 등?
     */
    @Bean
    public ItemWriter<String> sampleWriter() {
        return items -> {
            System.out.println("=======================");
            items.forEach(System.out::println);
            System.out.println("=======================");
        };
    }
}
