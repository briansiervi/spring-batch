package com.springbatch.migracaodados.migracao_dados_job.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import com.springbatch.migracaodados.migracao_dados_job.dominio.DadoBancario;

@Configuration
public class ArquivoDadosBancariosReaderConfig {
  @Bean
  public FlatFileItemReader<DadoBancario> dadosBancariosReader() {
    return new FlatFileItemReaderBuilder<DadoBancario>()
        .name("dadosBancariosReader")
        .resource(new FileSystemResource("filse/dados_bancarios.csv"))
        .delimited()
        .names("pessoaId", "agencia", "conta", "banco", "id")
        .addComment("--")
        .targetType(DadoBancario.class)
        .build();
  }
}
