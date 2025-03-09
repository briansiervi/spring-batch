package com.springbatch.migracaodados.migracao_dados_job.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.migracaodados.migracao_dados_job.dominio.DadoBancario;

@Configuration
public class MigrarDadosBancariosStepConfig {
  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step migrarDadosBancariosStep(
      @Qualifier("dadosBancariosReader") ItemReader<DadoBancario> arquivoDadosBancariosReader,
      @Qualifier("bancoDadosBancariosWriter") JdbcBatchItemWriter<DadoBancario> bancoDadosBancariosWriter) {
    return stepBuilderFactory
        .get("migrarDadosBancariosStep")
        .<DadoBancario, DadoBancario>chunk(1)
        .reader(arquivoDadosBancariosReader)
        .writer(bancoDadosBancariosWriter)
        .build();
  }
}