package br.com.briansiervi.spring_batch_08_desafio_leitores.dominio;

public class Arquivo {
  private int id;
  private String nomeLancamento;
  private String nomeItem;
  private String data;
  private double valor;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNomeLancamento() {
    return nomeLancamento;
  }

  public void setNomeLancamento(String nomeLancamento) {
    this.nomeLancamento = nomeLancamento;
  }

  public String getNomeItem() {
    return nomeItem;
  }

  public void setNomeItem(String nomeItem) {
    this.nomeItem = nomeItem;
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
    return "Arquivo [id=" + id + ", nomeLancamento=" + nomeLancamento + ", nomeItem=" + nomeItem + ", data=" + data
        + ", valor=" + valor + "]";
  }
}
