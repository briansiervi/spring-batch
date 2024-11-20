package br.com.briansiervi.spring_batch04_jdbc_pagingreader.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.briansiervi.spring_batch04_jdbc_pagingreader.dominio.Cliente;

@Configuration
public class JdbcPagingReaderWriterConfig {
  @Bean
  public ItemWriter<Cliente> jdbcPagingWriter() {
    return clientes -> clientes.forEach(System.out::println);
  }
}
