package br.com.briansiervi.spring_batch_12_desafio_processadores.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class ContasBancariasJobConfig {
  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Bean
  public Job contasBancariasJob(Step contasBancariasStep) {
    return jobBuilderFactory
        .get("contasBancariasJob")
        .start(contasBancariasStep)
        .incrementer(new RunIdIncrementer())
        .build();
  }
}
