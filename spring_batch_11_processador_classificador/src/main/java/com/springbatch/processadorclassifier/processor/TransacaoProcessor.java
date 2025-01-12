package com.springbatch.processadorclassifier.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.Nullable;

import com.springbatch.processadorclassifier.dominio.Transacao;

public class TransacaoProcessor implements ItemProcessor<Transacao, Transacao> {

  @Override
  @Nullable
  public Transacao process(@SuppressWarnings("null") Transacao transacao) throws Exception {
    System.out.println(String.format("\nAplicando regras de negócio na transação %s", transacao.getId()));
    return transacao;
  }
}
