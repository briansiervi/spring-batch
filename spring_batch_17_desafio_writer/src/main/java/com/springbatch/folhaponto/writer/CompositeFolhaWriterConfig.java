package com.springbatch.folhaponto.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.CompositeItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.folhaponto.dominio.FolhaPonto;

@Configuration
public class CompositeFolhaWriterConfig {
  @Bean
  public CompositeItemWriter<FolhaPonto> compositeFolhaWriter(
      ItemWriter<FolhaPonto> imprimeFolhaPontoWriter,
      ClassifierCompositeItemWriter<FolhaPonto> classifierFolhaPonto

  ) {
    return new CompositeItemWriterBuilder<FolhaPonto>()
        .delegates(imprimeFolhaPontoWriter, classifierFolhaPonto)
        .build();
  }
}
