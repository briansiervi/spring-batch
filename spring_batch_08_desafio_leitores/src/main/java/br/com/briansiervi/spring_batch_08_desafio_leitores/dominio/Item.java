package br.com.briansiervi.spring_batch_08_desafio_leitores.dominio;

public class Item {
  private String nome;
  private String data;
  private double valor;

  public Item(String nome, String data, Double valor) {
    this.nome = nome;
    this.data = data;
    this.valor = valor;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String item) {
    this.nome = item;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }
}
