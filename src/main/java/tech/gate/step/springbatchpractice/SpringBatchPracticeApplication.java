package tech.gate.step.springbatchpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 스프링 배치 작동하기 위해 선언해야 하는 어노테이션
//@EnableBatchProcessing
public class SpringBatchPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchPracticeApplication.class, args);
    }

}
