package br.com.briansiervi.springbatch01;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean
  Job imprimeOlaJob() {
    return jobBuilderFactory
        .get("imprimeOlaJob")
        .start(imprimeOlaStep())
        .incrementer(new RunIdIncrementer()) // nota: se utilizado, impede que o job retome o estado anterior à uma
                                             // interrupção, porém para testes, faz com que não tenhamos que ficar
                                             // limpando os metadados gerados
        .build();
  }

  private Step imprimeOlaStep() {
    return stepBuilderFactory
        .get("imprimeOlaStep")
        .tasklet(tasklet())
        .build();
  }

  private Tasklet tasklet() {
    // Tasklet tasklet = new Tasklet() {
    // @Override
    // public RepeatStatus execute(StepContribution contribution, ChunkContext
    // chunkContext) throws Exception {
    // System.out.println("Olá, mundo!");
    // return RepeatStatus.FINISHED;
    // }
    // };

    Tasklet tasklet = (StepContribution contribution, ChunkContext chunkContext) -> {
      System.out.println("Olá, mundo!");
      return RepeatStatus.FINISHED;
    };

    return tasklet;
  }
}