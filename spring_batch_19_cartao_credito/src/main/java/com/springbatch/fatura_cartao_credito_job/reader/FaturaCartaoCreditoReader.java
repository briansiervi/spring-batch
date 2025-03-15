package com.springbatch.fatura_cartao_credito_job.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.lang.Nullable;

import com.springbatch.fatura_cartao_credito_job.dominio.FaturaCartaoCredito;
import com.springbatch.fatura_cartao_credito_job.dominio.Transacao;

public class FaturaCartaoCreditoReader implements ItemStreamReader<FaturaCartaoCredito> {
  private ItemStreamReader<Transacao> delegate;
  private Transacao transacaoAtual;

  public FaturaCartaoCreditoReader(ItemStreamReader<Transacao> delegate) {
    this.delegate = delegate;
  }

  @Override
  @Nullable
  public FaturaCartaoCredito read() throws Exception {
    if (transacaoAtual == null)
      transacaoAtual = delegate.read();

    FaturaCartaoCredito faturaCartaoCredito = null;
    Transacao transacao = transacaoAtual;
    transacaoAtual = null;

    if (transacao != null) {
      faturaCartaoCredito = new FaturaCartaoCredito();
      faturaCartaoCredito.setCataoCredito(transacao.getCataoCredito());
      faturaCartaoCredito.setCliente(transacao.getCataoCredito().getCliente());
      faturaCartaoCredito.getTransacoes().add(transacao);

      while (isTransacaoRelacionada(transacao))
        faturaCartaoCredito.getTransacoes().add(transacaoAtual);
    }

    return faturaCartaoCredito;
  }

  private boolean isTransacaoRelacionada(Transacao transacao) throws Exception {
    return peek() != null && transacao.getCataoCredito().getNumeroCartaoCredito() == transacaoAtual.getCataoCredito()
        .getNumeroCartaoCredito();
  }

  private Transacao peek() throws Exception {
    transacaoAtual = delegate.read();
    return transacaoAtual;
  }

  @Override
  public void open(@SuppressWarnings("null") ExecutionContext executionContext) throws ItemStreamException {
    delegate.open(executionContext);
  }

  @Override
  public void update(@SuppressWarnings("null") ExecutionContext executionContext) throws ItemStreamException {
    delegate.update(executionContext);
  }

  @Override
  public void close() throws ItemStreamException {
    delegate.close();
  }
}
