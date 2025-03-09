package com.springbatch.fatura_cartao_credito_job.dominio;

import java.util.Date;

public class Transacao {
  private int id;
  private CartaoCredito CataoCredito;
  private String descricao;
  private Double valor;
  private Date data;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public CartaoCredito getCataoCredito() {
    return CataoCredito;
  }

  public void setCataoCredito(CartaoCredito cataoCredito) {
    CataoCredito = cataoCredito;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }
}
