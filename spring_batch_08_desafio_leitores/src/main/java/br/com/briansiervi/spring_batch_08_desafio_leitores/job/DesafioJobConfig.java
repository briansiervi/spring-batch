package br.com.briansiervi.spring_batch_08_desafio_leitores.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class DesafioJobConfig {

  @Autowired
  public JobBuilderFactory jobBuilderFactory;

  @Bean
  public Job desafioJob(Step leituraArquivoStep) {
    return jobBuilderFactory
        .get("desafioJob")
        .start(leituraArquivoStep)
        .incrementer(new RunIdIncrementer())
        .build();
  }

}
