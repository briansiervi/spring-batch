package br.com.briansiervi.spring_batch_12_desafio_processadores.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.briansiervi.spring_batch_12_desafio_processadores.dominio.Cliente;

@Configuration
public class desafioWriter {
  @Bean
  public ItemWriter<Cliente> jdbcItemWriter() {
    return clientes -> clientes.forEach(System.out::println);
  }
}
