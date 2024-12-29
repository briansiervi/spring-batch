package br.com.briansiervi.spring_batch_08_desafio_leitores.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class MultiplosLancamentosItemReaderConfig {

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @StepScope
  @Bean
  public MultiResourceItemReader multiplosLancamentosItemReader(
      @Value("#{jobParameters['arquivosResource']}") Resource[] arquivosResource,
      FlatFileItemReader flatFileItemReader

  ) {
    return new MultiResourceItemReaderBuilder<>()
        .name("multiplosLancamentosItemReader")
        .resources(arquivosResource)
        .delegate(new ArquivoLancamentoItemReader(flatFileItemReader))
        .build();
  }
}
