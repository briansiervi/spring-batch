package br.com.briansiervi.spring_batch_07_arquivo_multiplos_formatos.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoMultiplosFormatosWriterConfig {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ItemWriter leituraArquivoDelimitadoWriter() {
		return items -> items.forEach(System.out::println);
	}
}