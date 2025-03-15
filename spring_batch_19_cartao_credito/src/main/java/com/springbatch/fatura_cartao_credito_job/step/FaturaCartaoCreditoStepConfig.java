package com.springbatch.fatura_cartao_credito_job.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.fatura_cartao_credito_job.dominio.FaturaCartaoCredito;
import com.springbatch.fatura_cartao_credito_job.dominio.Transacao;
import com.springbatch.fatura_cartao_credito_job.reader.FaturaCartaoCreditoReader;
import com.springbatch.fatura_cartao_credito_job.writer.TotalTransacoesFooterCallBack;

@Configuration
public class FaturaCartaoCreditoStepConfig {
  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step faturaCartaoCreditoStep(
      ItemStreamReader<Transacao> lerTransacoesReader,
      ItemProcessor<FaturaCartaoCredito, FaturaCartaoCredito> carregarDadosClienteProcessor,
      ItemWriter<FaturaCartaoCredito> escreverFaturaCartaoCredito,
      TotalTransacoesFooterCallBack listener) {
    return stepBuilderFactory
        .get("faturaCartaoCreditoStep")
        .<FaturaCartaoCredito, FaturaCartaoCredito>chunk(1)
        .reader(new FaturaCartaoCreditoReader(lerTransacoesReader))
        .processor(carregarDadosClienteProcessor)
        .writer(escreverFaturaCartaoCredito)
        .listener(listener)
        .build();
  }
}
