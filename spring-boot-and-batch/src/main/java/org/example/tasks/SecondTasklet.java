package org.example.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class SecondTasklet implements Tasklet {

    private static final Logger log = LoggerFactory.getLogger(SecondTasklet.class);
    
    private final int foo;
    private final int bar;
    
    public SecondTasklet(int foo, int bar) {
        this.foo = foo;
        this.bar = bar;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext context) throws Exception {
        log.debug("Message from the second task");
        log.info("foo = " + foo + " and bar = " + bar);
        return RepeatStatus.FINISHED;
    }
}

