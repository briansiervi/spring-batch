package br.com.briansiervi.spring_batch_08_desafio_leitores.dominio;

import java.util.List;

import br.com.briansiervi.spring_batch_08_desafio_leitores.util.Util;

public class Lancamento {
  private int id;
  private String nome;
  private List<Item> itens;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String categoria) {
    this.nome = categoria;
  }

  public List<Item> getItens() {
    return itens;
  }

  public void setItens(List<Item> itens) {
    this.itens = itens;
  }

  @Override
  public String toString() {
    return "\n---- Demonstrativo orçamentário ----"
        + "\n[" + id + "] " + nome + " - "
        + (itens.isEmpty() ? "R$ 0,00"
            : (Util.imprimeReal(itens.stream().mapToDouble(item -> item.getValor()).sum())
                + Item.imprimeArray(itens)));
  }
}
