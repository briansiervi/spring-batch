package br.com.briansiervi.spring_batch_08_desafio_leitores.reader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;
import org.springframework.lang.Nullable;

import br.com.briansiervi.spring_batch_08_desafio_leitores.dominio.Arquivo;
import br.com.briansiervi.spring_batch_08_desafio_leitores.dominio.Item;
import br.com.briansiervi.spring_batch_08_desafio_leitores.dominio.Lancamento;

public class ArquivoLancamentoItemReader implements ResourceAwareItemReaderItemStream<Lancamento> {
  private Arquivo objAtual;
  private FlatFileItemReader<Object> delegate;

  public ArquivoLancamentoItemReader(FlatFileItemReader<Object> delegate) {
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
  @Nullable
  public Lancamento read() throws Exception {
    Lancamento lancamento = null;

    if (objAtual == null)
      objAtual = (Arquivo) delegate.read();

    Arquivo arquivo = (Arquivo) objAtual;

    if (arquivo != null) {
      lancamento = new Lancamento();
      lancamento.setId(objAtual.getId());
      lancamento.setNome(objAtual.getNomeLancamento());

      List<Item> itens = new ArrayList<Item>();
      itens.add(new Item(objAtual.getNomeItem(), objAtual.getData(), objAtual.getValor()));

      objAtual = null;
      while (peek() instanceof Arquivo && (objAtual.getId() == arquivo.getId())) {
        itens.add(new Item(objAtual.getNomeItem(), objAtual.getData(), objAtual.getValor()));
      }

      lancamento.setItens(itens);
    }

    return lancamento;
  }

  private Arquivo peek() throws Exception {
    objAtual = (Arquivo) delegate.read();
    return (Arquivo) objAtual;
  }

  @SuppressWarnings("null")
  @Override
  public void setResource(Resource resource) {
    delegate.setResource(resource);
  }

}
