package br.com.briansiervi.spring_batch_08_desafio_leitores.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class FlatFileItemReaderConfig {

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @StepScope
  @Bean
  public FlatFileItemReader flatFileItemReader(
      @Value("#{jobParameters['arquivosResource']}") Resource arquivosResource,
      LineMapper lineMapper) {
    return new FlatFileItemReaderBuilder<>()
        .name("flatFileItemReader")
        .resource(arquivosResource)
        .lineMapper(lineMapper)
        .build();
  }
}
