package com.springbatch.folhaponto.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.folhaponto.dominio.FolhaPonto;
import com.springbatch.folhaponto.dominio.Funcionario;
import com.springbatch.folhaponto.reader.FuncionarioReader;

@Configuration
public class FolhaPontoStepConfig {
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step folhaPontoStep(
			JdbcCursorItemReader<Funcionario> funcionarioReaderJdbc,
			ItemProcessor<Funcionario, FolhaPonto> folhaPontoProcessor,
			FlatFileItemWriter<FolhaPonto> folhaPontoInvalidaWriter,
			CompositeItemWriter<FolhaPonto> compositeFolhaWriter) {
		return stepBuilderFactory
				.get("folhaPontoStep")
				.<Funcionario, FolhaPonto>chunk(100)
				.reader(new FuncionarioReader(funcionarioReaderJdbc))
				.processor(folhaPontoProcessor)
				.writer(compositeFolhaWriter)
				.stream(folhaPontoInvalidaWriter)
				.build();
	}
}
