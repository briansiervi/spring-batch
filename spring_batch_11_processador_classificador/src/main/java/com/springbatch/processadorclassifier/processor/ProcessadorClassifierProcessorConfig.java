package com.springbatch.processadorclassifier.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.processadorclassifier.dominio.Cliente;

import ch.qos.logback.core.net.server.Client;

@Configuration
public class ProcessadorClassifierProcessorConfig {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ItemProcessor processadorClassifierProcessor() {
		return new ClassifierCompositeItemProcessorBuilder<>()
				.classifier(classifier())
				.build();
	}

	@SuppressWarnings("rawtypes")
	private Classifier classifier() {
		return new Classifier<Object, ItemProcessor>() {
			@Override
			public ItemProcessor classify(Object objeto) {
				if (objeto instanceof Cliente)
					return new ClienteProcessor();
				else
					return new TransacaoProcessor();
			}
		};
	}
}
