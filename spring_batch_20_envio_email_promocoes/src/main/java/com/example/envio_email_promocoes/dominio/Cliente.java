package com.example.envio_email_promocoes.dominio;

public class Cliente {
  private int Id;
  private String nome;
  private String email;

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
