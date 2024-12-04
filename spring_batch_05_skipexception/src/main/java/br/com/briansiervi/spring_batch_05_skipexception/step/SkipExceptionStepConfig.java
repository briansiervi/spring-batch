package br.com.briansiervi.spring_batch_05_skipexception.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.briansiervi.spring_batch_05_skipexception.dominio.Cliente;

@Configuration
public class SkipExceptionStepConfig {
  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step skipExceptionStep(ItemReader<Cliente> skipExceptionReader, ItemWriter<Cliente> skipExceptionWriter) {
    return stepBuilderFactory
        .get("skipExceptionStep")
        .<Cliente, Cliente>chunk(11)
        .reader(skipExceptionReader)
        .writer(skipExceptionWriter)
        .faultTolerant()
        .skip(Exception.class)
        .skipLimit(2)
        .build();
  }
}
