package br.com.briansiervi.spring_batch_05_skipexception.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.briansiervi.spring_batch_05_skipexception.dominio.Cliente;

@Configuration
public class SkipExceptionReaderConfig {
  @Bean
  public ItemReader<Cliente> skipExceptionReader(@Qualifier("appDataSource") DataSource dataSource) {
    return new JdbcCursorItemReaderBuilder<Cliente>()
        .name("skipExceptionReader")
        .dataSource(dataSource)
        .sql("select * from cliente")
        .beanRowMapper(Cliente.class)
        .build();
  }
}
