package br.com.briansiervi.spring_batch_12_desafio_processadores.dominio;

public class Cliente {
  private String nome;
  private int idade;
  private String email;
  private Double faixaSalarial;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Double getFaixaSalarial() {
    return faixaSalarial;
  }

  public void setFaixaSalarial(Double faixaSalarial) {
    this.faixaSalarial = faixaSalarial;
  }

  @Override
  public String toString() {
    return "Cliente [nome=" + nome + ", idade=" + idade + ", email=" + email + ", faixaSalarial=" + faixaSalarial + "]";
  }
}
