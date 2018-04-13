package org.example.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;

public class FirstTasklet implements Tasklet {

    private static final Logger log = LoggerFactory.getLogger(FirstTasklet.class);

    @Value("${message.from.task}")
    private String message;
    
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext context) throws Exception {
        log.info("Message from the first task");
        log.info(message);
        return RepeatStatus.FINISHED;
    }
}

