package com.springbatch.migracaodados.migracao_dados_job.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.migracaodados.migracao_dados_job.dominio.Pessoa;

@Configuration
public class MigrarPessoaStepConfig {
  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step migrarPessoaStep(
      @Qualifier("arquivoPessoaReader") ItemReader<Pessoa> arquivoPessoaReader,
      ClassifierCompositeItemWriter<Pessoa> pessoaClassifierWriter,
      FlatFileItemWriter<Pessoa> arquivoPessoaInvalidaWriter) {
    return stepBuilderFactory
        .get("migrarPessoaStep")
        .<Pessoa, Pessoa>chunk(1)
        .reader(arquivoPessoaReader)
        .writer(pessoaClassifierWriter)
        .stream(arquivoPessoaInvalidaWriter)
        .build();
  }
}
