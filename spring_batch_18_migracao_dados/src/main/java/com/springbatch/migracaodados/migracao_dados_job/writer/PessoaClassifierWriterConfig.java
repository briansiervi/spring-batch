package com.springbatch.migracaodados.migracao_dados_job.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemWriterBuilder;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.migracaodados.migracao_dados_job.dominio.Pessoa;

@Configuration
public class PessoaClassifierWriterConfig {
  @Bean
  public ClassifierCompositeItemWriter<Pessoa> pessoaClassifierWriter(
      JdbcBatchItemWriter<Pessoa> bancoPessoaWriter,
      FlatFileItemWriter<Pessoa> arquivoPessoaInvalidaWriter) {
    return new ClassifierCompositeItemWriterBuilder<Pessoa>()
        .classifier(classifier(bancoPessoaWriter, arquivoPessoaInvalidaWriter))
        .build();
  }

  private Classifier<Pessoa, ItemWriter<? super Pessoa>> classifier(JdbcBatchItemWriter<Pessoa> bancoPessoaWriter,
      FlatFileItemWriter<Pessoa> arquivoPessoaInvalidaWriter) {
    return new Classifier<Pessoa, ItemWriter<? super Pessoa>>() {

      @Override
      public ItemWriter<? super Pessoa> classify(Pessoa pessoa) {
        if (pessoa.isValida())
          return bancoPessoaWriter;
        else
          return arquivoPessoaInvalidaWriter;
      }
    };
  }
}
