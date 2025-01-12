package br.com.briansiervi.spring_batch_12_desafio_processadores.dominio;

public class Conta {
  private int id;
  private ContaEnum tipo;
  private Double limite;
  private String clienteId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public ContaEnum getTipo() {
    return tipo;
  }

  public void setTipo(ContaEnum tipo) {
    this.tipo = tipo;
  }

  public Double getLimite() {
    return limite;
  }

  public void setLimite(Double limite) {
    this.limite = limite;
  }

  public String getClienteId() {
    return clienteId;
  }

  public void setClienteId(String clienteId) {
    this.clienteId = clienteId;
  }

  @Override
  public String toString() {
    return "Conta [id=" + id + ", tipo=" + tipo + ", limite=" + limite + ", clienteId=" + clienteId + "]";
  }
}
