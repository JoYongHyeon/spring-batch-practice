package tech.gate.step.springbatchpractice.taskletClass;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class CustomTasklet implements Tasklet {


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        /**
         * Spring Batch 5 부터는 Spring 이 자동으로 주입하지 않게 변경
         * 즉, 이제는 "Spring 이 콜백으로 주입해줄 테니까 기다려" 가 아닌
         * "필요하면 chunkContext에서 직접 꺼내 써라" 구조로 바뀜
         */
        StepExecution stepExecution = chunkContext.getStepContext().getStepExecution();

        System.out.println("======= CustomTasklet 실행됨 =======");
        System.out.println("Step Name: " + stepExecution.getStepName());
        System.out.println("Job Name: " + stepExecution.getJobExecution().getJobInstance().getJobName());

        stepExecution.getExecutionContext().put("key", "value");

        return RepeatStatus.FINISHED;
    }

}
