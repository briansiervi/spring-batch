package br.com.briansiervi.spring_batch_07_arquivo_multiplos_formatos.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;
import br.com.briansiervi.spring_batch_07_arquivo_multiplos_formatos.dominio.Cliente;
import br.com.briansiervi.spring_batch_07_arquivo_multiplos_formatos.dominio.Transacao;

public class ArquivoClienteTransacaoReader
    implements ResourceAwareItemReaderItemStream<Cliente> {
  private Object objAtual;
  private FlatFileItemReader<Object> delegate;

  public ArquivoClienteTransacaoReader(FlatFileItemReader<Object> delegate) {
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

  @SuppressWarnings("null")
  @Override
  public void setResource(Resource resource) {
    delegate.setResource(resource);
  }

}
