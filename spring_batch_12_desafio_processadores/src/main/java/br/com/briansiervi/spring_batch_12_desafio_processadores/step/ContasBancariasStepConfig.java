package br.com.briansiervi.spring_batch_12_desafio_processadores.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.briansiervi.spring_batch_12_desafio_processadores.dominio.Cliente;
import br.com.briansiervi.spring_batch_12_desafio_processadores.dominio.Conta;

@Configuration
public class ContasBancariasStepConfig {
  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step contasBancariasStep(ItemReader<Cliente> contasBancariasReader,
      ItemProcessor<Cliente, Conta> contasBancariasProcessor,
      ItemWriter<Conta> contasBancariasWriter) {
    return stepBuilderFactory
        .get("contasBancariasStep")
        .<Cliente, Conta>chunk(1)
        .reader(contasBancariasReader)
        .processor(contasBancariasProcessor)
        .writer(contasBancariasWriter)
        .build();
  }
}
