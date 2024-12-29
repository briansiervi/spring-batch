package br.com.briansiervi.spring_batch_08_desafio_leitores.dominio;

import java.util.List;

import br.com.briansiervi.spring_batch_08_desafio_leitores.util.Util;

public class Item {
  private String nome;
  private String data;
  private double valor;

  public Item(String nome, String data, double valor) {
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

  @Override
  public String toString() {
    return "\n\t[" + data + "] " + nome + " - " + Util.imprimeReal(valor) + "";
  }

  public static String imprimeArray(List<Item> itens) {
    StringBuilder builder = new StringBuilder();
    for (Item item : itens) {
      builder.append(item);
    }
    String text = builder.toString();
    return text;
  }

}
