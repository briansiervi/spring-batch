package br.com.briansiervi.spring_batch_12_desafio_processadores.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import br.com.briansiervi.spring_batch_12_desafio_processadores.dominio.Cliente;

@Configuration
public class ContasBancariasReader {
  @Bean
  public JdbcPagingItemReader<Cliente> jdbcPagingItemReader(@Qualifier("xptoDataSource") DataSource dataSource,
      PagingQueryProvider queryProvider) {
    return new JdbcPagingItemReaderBuilder<Cliente>()
        .name("jdbcPagingItemReader")
        .dataSource(dataSource)
        .queryProvider(queryProvider)
        .pageSize(10)
        .rowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class))
        .build();
  }

  @Bean
  public SqlPagingQueryProviderFactoryBean queryProvider(@Qualifier("xptoDataSource") DataSource dataSource) {
    SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();

    queryProvider.setDataSource(dataSource);
    queryProvider.setSelectClause("select * ");
    queryProvider.setFromClause("from cliente");
    queryProvider.setSortKey("email");

    return queryProvider;
  }

  // @SuppressWarnings({ "unchecked", "rawtypes" })
  // @Bean
  // public JdbcCursorItemReader<Cliente>
  // jdbcCursorItemReader(@Qualifier("xptoDataSource") DataSource dataSource) {
  // return new JdbcCursorItemReaderBuilder()
  // .name("jdbcCursorItemReader")
  // .dataSource(dataSource)
  // .sql("select * from cliente")
  // .rowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class))
  // .build();
  // }
}
