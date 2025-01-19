package br.com.briansiervi.spring_batch_12_desafio_processadores.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.briansiervi.spring_batch_12_desafio_processadores.dominio.Conta;

@Configuration
public class ContasBancariasWriter {
  @Bean
  public ItemWriter<Conta> jdbcItemWriter() {
    return contas -> contas.forEach(System.out::println);
  }
}
