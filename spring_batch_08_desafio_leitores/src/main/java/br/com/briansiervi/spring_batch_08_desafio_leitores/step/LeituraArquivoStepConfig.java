package br.com.briansiervi.spring_batch_08_desafio_leitores.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.briansiervi.spring_batch_08_desafio_leitores.dominio.Lancamento;

@Configuration
public class LeituraArquivoStepConfig {

  @Autowired
  public StepBuilderFactory stepBuilderFactory;

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Bean
  public Step leituraArquivoStep(
      MultiResourceItemReader<Lancamento> multiplosLancamentosItemReader,
      ItemWriter leituraArquivoItemWriter) {
    return stepBuilderFactory
        .get("leituraArquivoStep")
        .chunk(1)
        .reader(multiplosLancamentosItemReader)
        .writer(leituraArquivoItemWriter)
        .build();
  }

}
