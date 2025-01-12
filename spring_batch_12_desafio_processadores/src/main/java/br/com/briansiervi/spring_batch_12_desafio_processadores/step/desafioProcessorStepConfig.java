package br.com.briansiervi.spring_batch_12_desafio_processadores.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.briansiervi.spring_batch_12_desafio_processadores.dominio.Cliente;

@Configuration
public class desafioProcessorStepConfig {
  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step desafioStep(ItemReader<Cliente> desafioReader, ItemWriter<Cliente> desafioWriter) {
    return stepBuilderFactory
        .get("desafioStep")
        .<Cliente, Cliente>chunk(1)
        .reader(desafioReader)
        .writer(desafioWriter)
        .build();
  }
}
