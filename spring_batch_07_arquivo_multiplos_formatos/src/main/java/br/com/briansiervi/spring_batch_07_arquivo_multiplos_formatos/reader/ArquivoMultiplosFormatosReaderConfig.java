package br.com.briansiervi.spring_batch_07_arquivo_multiplos_formatos.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoMultiplosFormatosReaderConfig {

	@Bean
	public FlatFileItemReader arquivoMultiplosFormatosItemReader() {
		// TODO: Implementar leitor de múltiplos formatos.
		return null;
	}

}
