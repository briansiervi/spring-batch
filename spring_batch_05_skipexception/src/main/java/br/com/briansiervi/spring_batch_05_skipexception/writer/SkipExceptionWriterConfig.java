package br.com.briansiervi.spring_batch_05_skipexception.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.briansiervi.spring_batch_05_skipexception.dominio.Cliente;

@Configuration
public class SkipExceptionWriterConfig {
  @Bean
  public ItemWriter<Cliente> printWriter() {
    return clientes -> clientes.forEach(System.out::println);
  }
}
