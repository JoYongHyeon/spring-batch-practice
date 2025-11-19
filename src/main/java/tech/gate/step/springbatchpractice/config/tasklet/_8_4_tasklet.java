package tech.gate.step.springbatchpractice.config.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;


public class _8_4_tasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("==================== _8_4_tasklet ====================");

        // tasklet3에서 실패했지만 여기서 출력이 되는지?
        System.out.println("name : " + chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().get("name"));
        return RepeatStatus.FINISHED;
    }
}
