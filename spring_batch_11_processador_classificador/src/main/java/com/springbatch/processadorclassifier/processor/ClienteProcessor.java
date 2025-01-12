package com.springbatch.processadorclassifier.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.Nullable;

import com.springbatch.processadorclassifier.dominio.Cliente;

public class ClienteProcessor implements ItemProcessor<Cliente, Cliente> {

  @Override
  @Nullable
  public Cliente process(@SuppressWarnings("null") Cliente cliente) throws Exception {
    System.out.println(String.format("\nAplicando regras de negócio no cliente %s", cliente.getEmail()));
    return cliente;
  }
}
