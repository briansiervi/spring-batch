package com.springbatch.folhaponto.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;

import com.springbatch.folhaponto.dominio.FolhaPonto;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassifierFolhaPontoConfig {
  @Bean
  public ClassifierCompositeItemWriter<FolhaPonto> classifierFolhaPonto(
      @Qualifier("folhaPontoValidaWriter") JdbcBatchItemWriter<FolhaPonto> folhaPontoValidaWriter,
      FlatFileItemWriter<FolhaPonto> folhaPontoInvalidaWriter) {
    return new ClassifierCompositeItemWriterBuilder<FolhaPonto>()
        .classifier(classifier(
            folhaPontoValidaWriter, folhaPontoInvalidaWriter))
        .build();
  }

  private Classifier<FolhaPonto, ItemWriter<? super FolhaPonto>> classifier(
      @Qualifier("folhaPontoValidaWriter") JdbcBatchItemWriter<FolhaPonto> folhaPontoValidaWriter,
      FlatFileItemWriter<FolhaPonto> folhaPontoInvalidaWriter) {
    return new Classifier<FolhaPonto, ItemWriter<? super FolhaPonto>>() {
      @Override
      public ItemWriter<? super FolhaPonto> classify(FolhaPonto folhaPonto) {
        if (folhaPonto.getNome() != null)
          return folhaPontoValidaWriter;
        else
          return folhaPontoInvalidaWriter;
      }
    };
  }

}
