package br.com.briansiervi.springbatch03_jdbc_cursor_reader.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.briansiervi.springbatch03_jdbc_cursor_reader.dominio.Cliente;

@Configuration
public class JdbcCursorReaderStepConfig {
  @Autowired
  public StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step jdbcCursorReaderStep(ItemReader<Cliente> jdbcCursorReader, ItemWriter<Cliente> jdbcCursorWriter) {
    return stepBuilderFactory
        .get("jdbcCursorReaderStep")
        .<Cliente, Cliente>chunk(1)
        .reader(jdbcCursorReader)
        .writer(jdbcCursorWriter)
        .build();
  }
}
