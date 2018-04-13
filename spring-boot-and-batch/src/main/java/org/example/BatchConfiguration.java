package org.example;

import org.example.tasks.FirstTasklet;
import org.example.tasks.SecondTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Batch configuration.
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    /**
     * The first step of the job.
     * 
     * @return the first job step.
     */
    @Bean
    public Step firstStep() {
        return stepBuilderFactory.get("firstStep").tasklet(firstTask()).build();
    }
    
    @Bean
    public Tasklet firstTask() {
        return new FirstTasklet();
    }

    /**
     * The second step of the job.
     * 
     * @return the first job step.
     */
    @Bean
    public Step secondStep() {
        return stepBuilderFactory.get("secondStep").tasklet(secondTask()).build();
    }

    @Bean
    public Tasklet secondTask() {
        return new SecondTasklet();
    }

    /**
     * Sample job.
     * 
     * @return the job to execute.
     */
    @Bean
    public Job sampleJob() {
        return jobBuilderFactory.get("sampleJob")
            .incrementer(new RunIdIncrementer())
            .start(firstStep())
            .next(secondStep())
            .build();
    }
}
