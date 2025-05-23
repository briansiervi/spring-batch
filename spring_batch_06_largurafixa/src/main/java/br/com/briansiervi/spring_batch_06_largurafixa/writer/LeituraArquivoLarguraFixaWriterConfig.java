package br.com.briansiervi.spring_batch_06_largurafixa.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.briansiervi.spring_batch_06_largurafixa.dominio.Cliente;

@Configuration
public class LeituraArquivoLarguraFixaWriterConfig {
	@Bean
	public ItemWriter<Cliente> leituraArquivoLarguraFixaWriter() {
		return items -> items.forEach(System.out::println);
		// return items -> {
		// for (Cliente cliente : items) {
		// if (cliente.getNome().equals("Maria"))
		// throw new Exception();
		// else
		// System.out.println(cliente);
		// }
		// };
	}
}
