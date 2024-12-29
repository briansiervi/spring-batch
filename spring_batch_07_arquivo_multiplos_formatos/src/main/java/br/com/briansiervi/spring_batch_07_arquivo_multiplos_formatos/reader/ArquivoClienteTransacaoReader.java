package br.com.briansiervi.spring_batch_07_arquivo_multiplos_formatos.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.lang.Nullable;

import br.com.briansiervi.spring_batch_07_arquivo_multiplos_formatos.dominio.Cliente;
import br.com.briansiervi.spring_batch_07_arquivo_multiplos_formatos.dominio.Transacao;

public class ArquivoClienteTransacaoReader implements ItemStreamReader<Cliente> {
  private Object objAtual;
  private ItemStreamReader<Object> delegate;

  public ArquivoClienteTransacaoReader(ItemStreamReader<Object> delegate) {
    this.delegate = delegate;
  }

  @SuppressWarnings("null")
  @Override
  public void open(ExecutionContext executionContext) throws ItemStreamException {
    delegate.open(executionContext);
  }

  @SuppressWarnings("null")
  @Override
  public void update(ExecutionContext executionContext) throws ItemStreamException {
    delegate.update(executionContext);
  }

  @Override
  public void close() throws ItemStreamException {
    delegate.close();
  }

  @Override
  public Cliente read() throws Exception {
    if (objAtual == null)
      objAtual = delegate.read();

    Cliente cliente = (Cliente) objAtual;
    objAtual = null;

    if (cliente != null) {
      while (peek() instanceof Transacao) {
        cliente.getTransacoes().add((Transacao) objAtual);
      }
    }
    return cliente;
  }

  private Object peek() throws Exception {
    objAtual = delegate.read();
    return objAtual;
  }

}
