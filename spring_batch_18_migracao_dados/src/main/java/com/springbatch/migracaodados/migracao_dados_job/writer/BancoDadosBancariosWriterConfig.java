package com.springbatch.migracaodados.migracao_dados_job.writer;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.migracaodados.migracao_dados_job.dominio.DadoBancario;

@Configuration
public class BancoDadosBancariosWriterConfig {
  @Bean
  public JdbcBatchItemWriter<DadoBancario> bancoDadosBancariosWriter(
      @Qualifier("appDataSource") DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<DadoBancario>()
        .dataSource(dataSource)
        .sql(
            "INSERT INTO dados_bancarios (id, pessoa_id, agencia, conta, banco) VALUES (:id, :pessoaId, :agencia, :conta, :banco)")
        .beanMapped()
        .build();
  }
}