package org.example.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class SecondTasklet implements Tasklet {

    private static final Logger log = LoggerFactory.getLogger(SecondTasklet.class);

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext context) throws Exception {
        log.debug("Message from the second task");
        return RepeatStatus.FINISHED;
    }
}

