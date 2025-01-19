package br.com.briansiervi.spring_batch_12_desafio_processadores.dominio;

import java.util.concurrent.atomic.AtomicInteger;

public class Conta {
  private int id;
  private String tipo;
  private Double limite;
  private String clienteId;
  private static final AtomicInteger idAtual = new AtomicInteger(0);

  public Conta(String tipo, Double limite, String clienteId) {
    this.id = idAtual.incrementAndGet();
    this.tipo = tipo;
    this.clienteId = clienteId;
    this.limite = limite;
  }

  public String getTipo() {
    return tipo;
  }

  public Double getLimite() {
    return limite;
  }

  @Override
  public String toString() {
    return "Conta [id=" + id + ", tipo=" + tipo + ", limite=" + limite + ", clienteId=" + clienteId + "]";
  }
}
