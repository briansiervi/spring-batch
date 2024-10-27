package br.com.briansiervi.springbatch01.job;

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
public class ImprimeOlaJobConfig {
  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Bean
  Job imprimeOlaJob(Step imprimeOlaStep) {
    return jobBuilderFactory
        .get("imprimeOlaJob")
        .start(imprimeOlaStep)
        .incrementer(new RunIdIncrementer()) // nota: se utilizado, impede que o job retome o estado anterior à uma
                                             // interrupção, porém para testes, faz com que não tenhamos que ficar
                                             // limpando os metadados gerados
        .build();
  }
}