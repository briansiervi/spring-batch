package com.springbatch.demonstrativoorcamentario.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.MultiResourceItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.demonstrativoorcamentario.dominio.GrupoLancamento;
import com.springbatch.demonstrativoorcamentario.reader.GrupoLancamentoReader;
import com.springbatch.demonstrativoorcamentario.writer.DemonstrativoOrcamentarioRodape;

@Configuration
public class DemonstrativoOrcamentarioStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	public static final int CHUNK_SIZE = 1;

	@Bean
	public Step demonstrativoOrcamentarioStep(
			GrupoLancamentoReader demonstrativoOrcamentarioReader,
			MultiResourceItemWriter<GrupoLancamento> multiDemonstrativoOrcamentarioWriter,
			DemonstrativoOrcamentarioRodape rodapeCallbackListener) {
		return stepBuilderFactory
				.get("demonstrativoOrcamentarioStep")
				.<GrupoLancamento, GrupoLancamento>chunk(CHUNK_SIZE)
				.reader(demonstrativoOrcamentarioReader)
				.writer(multiDemonstrativoOrcamentarioWriter)
				.listener(rodapeCallbackListener)
				.build();
	}
}
