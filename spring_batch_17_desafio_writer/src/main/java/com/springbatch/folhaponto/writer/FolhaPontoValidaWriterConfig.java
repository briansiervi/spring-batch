package com.springbatch.folhaponto.writer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.folhaponto.dominio.FolhaPonto;

@Configuration
public class FolhaPontoValidaWriterConfig {
  @Bean
  public JdbcBatchItemWriter<FolhaPonto> folhaPontoValidaWriter(
      @Qualifier("appDataSource") DataSource appDataSource) {
    return new JdbcBatchItemWriterBuilder<FolhaPonto>()
        .dataSource(appDataSource)
        .sql("INSERT INTO folha_ponto (mes, ano, funcionario_id, registros_ponto) VALUES (?, ?, ?, ?)")
        .itemPreparedStatementSetter(itemPreparedStatementSetter())
        .build();
  }

  private ItemPreparedStatementSetter<FolhaPonto> itemPreparedStatementSetter() {
    return new ItemPreparedStatementSetter<FolhaPonto>() {
      @Override
      public void setValues(@SuppressWarnings("null") FolhaPonto item, @SuppressWarnings("null") PreparedStatement ps)
          throws SQLException {
        ps.setInt(1, item.getMes());
        ps.setInt(2, item.getAno());
        ps.setInt(3, item.getMatricula());
        ps.setString(4, item.getRegistrosPontoTexto());
      }
    };
  }
}
