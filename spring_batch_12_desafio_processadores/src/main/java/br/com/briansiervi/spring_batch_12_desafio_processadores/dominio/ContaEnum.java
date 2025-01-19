package br.com.briansiervi.spring_batch_12_desafio_processadores.dominio;

public enum ContaEnum {
  PRATA(1),
  OURO(2),
  PLATINA(3),
  DIAMANTE(4);

  private final int valor;

  ContaEnum(int valor) {
    this.valor = valor;
  }

  public int getValor() {
    return valor;
  }
}
