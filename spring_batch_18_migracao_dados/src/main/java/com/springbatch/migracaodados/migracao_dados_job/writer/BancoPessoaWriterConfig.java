package com.springbatch.migracaodados.migracao_dados_job.writer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.migracaodados.migracao_dados_job.dominio.Pessoa;

@Configuration
public class BancoPessoaWriterConfig {
  @SuppressWarnings("unchecked")
  @Bean
  public JdbcBatchItemWriter<Pessoa> bancoPessoaWriter(
      @Qualifier("appDataSource") DataSource dataSource) {
    return new JdbcBatchItemWriterBuilder<Pessoa>()
        .dataSource(dataSource)
        .sql("INSERT INTO pessoa (id, nome, email, data_nascimento, idade) VALUES (?, ?, ?, ?, ?)")
        .itemPreparedStatementSetter(itemPreparedStatementSetter())
        .build();
  }

  @SuppressWarnings("rawtypes")
  private ItemPreparedStatementSetter itemPreparedStatementSetter() {
    return new ItemPreparedStatementSetter<Pessoa>() {
      @SuppressWarnings("null")
      @Override
      public void setValues(Pessoa pessoa, PreparedStatement ps) throws SQLException {
        ps.setInt(1, pessoa.getId());
        ps.setString(2, pessoa.getNome());
        ps.setString(3, pessoa.getEmail());
        ps.setDate(4, new Date(pessoa.getDataNascimento().getTime()));
        ps.setInt(5, pessoa.getIdade());
      }
    };
  }
}
