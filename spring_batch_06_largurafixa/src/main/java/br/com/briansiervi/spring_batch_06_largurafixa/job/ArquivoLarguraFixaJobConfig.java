package br.com.briansiervi.spring_batch_06_largurafixa.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class ArquivoLarguraFixaJobConfig {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	public Job arquivoLarguraFixaJob(Step leituraArquivoLarguraFixaStep) {
		return jobBuilderFactory
				.get("arquivoLarguraFixaJob")
				.start(leituraArquivoLarguraFixaStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
