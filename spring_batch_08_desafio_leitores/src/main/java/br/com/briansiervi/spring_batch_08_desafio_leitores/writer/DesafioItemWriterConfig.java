package br.com.briansiervi.spring_batch_08_desafio_leitores.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DesafioItemWriterConfig {

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Bean
  public ItemWriter leituraArquivoItemWriter() {
    return items -> items.forEach(System.out::println);
  }
}
