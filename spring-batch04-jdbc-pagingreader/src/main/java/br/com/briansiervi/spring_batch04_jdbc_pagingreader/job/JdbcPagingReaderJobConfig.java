package br.com.briansiervi.spring_batch04_jdbc_pagingreader.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class JdbcPagingReaderJobConfig {
  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Bean
  public Job jdbcPagingReaderJob(Step jdbcPagingReaderStep) {
    return jobBuilderFactory
        .get("jdbcPagingReaderJob")
        .start(jdbcPagingReaderStep)
        .incrementer(new RunIdIncrementer())
        .build();
  }
}
