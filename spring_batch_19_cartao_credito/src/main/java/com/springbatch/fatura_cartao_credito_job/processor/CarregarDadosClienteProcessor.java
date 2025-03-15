package com.springbatch.fatura_cartao_credito_job.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.springbatch.fatura_cartao_credito_job.dominio.Cliente;
import com.springbatch.fatura_cartao_credito_job.dominio.FaturaCartaoCredito;

@Component
public class CarregarDadosClienteProcessor implements ItemProcessor<FaturaCartaoCredito, FaturaCartaoCredito> {
  private RestTemplate restTemplate = new RestTemplate();

  @Override
  @Nullable
  public FaturaCartaoCredito process(@SuppressWarnings("null") FaturaCartaoCredito faturaCartaoCredito)
      throws Exception {
    String uri = String.format("http://my-json-server.typicode.com/giuliana-bezerra/demo/profile/%d",
        faturaCartaoCredito.getCliente().getId());

    ResponseEntity<Cliente> response = restTemplate.getForEntity(uri, Cliente.class);

    if (response.getStatusCode() != HttpStatus.OK)
      throw new ValidationException("Cliente não encontrado!");

    faturaCartaoCredito.setCliente(response.getBody());
    return faturaCartaoCredito;
  }
}
