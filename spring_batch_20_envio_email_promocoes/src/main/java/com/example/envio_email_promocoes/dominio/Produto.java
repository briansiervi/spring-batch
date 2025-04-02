package com.example.envio_email_promocoes.dominio;

public class Produto {
  private int Id;
  private String nome;
  private String descricao;
  private Double preco;

  public int getId() {
    return Id;
  }

  public void setId(int id) {
    Id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }
}
