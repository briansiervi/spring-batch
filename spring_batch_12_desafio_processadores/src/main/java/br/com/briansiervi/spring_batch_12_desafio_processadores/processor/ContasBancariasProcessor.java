package br.com.briansiervi.spring_batch_12_desafio_processadores.processor;

import br.com.briansiervi.spring_batch_12_desafio_processadores.dominio.*;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

@Configuration
public class ContasBancariasProcessor implements ItemProcessor<Cliente, Conta> {
  @Override
  @Nullable
  public Conta process(@SuppressWarnings("null") Cliente cliente) throws Exception {
    String tipo = getTipo(cliente);

    return new Conta(tipo, getLimite(tipo), cliente.getEmail());
  }

  private String getTipo(Cliente cliente) {
    if (cliente.getFaixaSalarial() >= 10000.00)
      return ContaEnum.DIAMANTE.toString();

    if (cliente.getFaixaSalarial() >= 5001.00)
      return ContaEnum.PLATINA.toString();

    if (cliente.getFaixaSalarial() >= 3001.00)
      return ContaEnum.OURO.toString();

    return ContaEnum.PRATA.toString();
  }

  private Double getLimite(String tipo) {
    if (tipo.equalsIgnoreCase(ContaEnum.DIAMANTE.toString()))
      return 5000.00;

    if (tipo.equalsIgnoreCase(ContaEnum.PLATINA.toString()))
      return 2500.00;

    if (tipo.equalsIgnoreCase(ContaEnum.OURO.toString()))
      return 1000.00;

    return 500.00;
  }
}
