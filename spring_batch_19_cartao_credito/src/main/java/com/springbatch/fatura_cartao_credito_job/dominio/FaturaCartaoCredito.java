package com.springbatch.fatura_cartao_credito_job.dominio;

import java.util.ArrayList;
import java.util.List;

public class FaturaCartaoCredito {
  private Cliente cliente;
  private CartaoCredito cataoCredito;
  private List<Transacao> transacoes = new ArrayList<>();

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public CartaoCredito getCataoCredito() {
    return cataoCredito;
  }

  public void setCataoCredito(CartaoCredito cataoCredito) {
    this.cataoCredito = cataoCredito;
  }

  public List<Transacao> getTransacoes() {
    return transacoes;
  }

  public void setTransacoes(List<Transacao> transacoes) {
    this.transacoes = transacoes;
  }

  public Double getTotal() {
    return transacoes
        .stream()
        .mapToDouble(Transacao::getValor)
        .reduce(0.0, Double::sum);
  }
}
