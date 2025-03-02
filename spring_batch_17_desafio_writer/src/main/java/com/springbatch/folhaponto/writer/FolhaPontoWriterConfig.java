package com.springbatch.folhaponto.writer;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.folhaponto.dominio.FolhaPonto;

@Configuration
public class FolhaPontoWriterConfig {
	@Bean
	public ItemWriter<FolhaPonto> imprimeFolhaPontoWriter() {
		return folhasPonto -> {
			imprimeCabecalho();
			folhasPonto.forEach(folhaPonto -> {
				imprimePontos(folhaPonto);
			});
			imprimeRodape();
		};
	}

	private void imprimePontos(FolhaPonto folhaPonto) {
		StringBuilder writer = new StringBuilder();
		writer.append(String.format("----------------------------------------------------------------------------\n"));
		writer.append(String.format("NOME:%s\n", folhaPonto.getNome()));
		writer.append(String.format("MATRICULA:%s\n", folhaPonto.getMatricula()));
		writer.append(String.format("----------------------------------------------------------------------------\n"));
		writer.append(String.format("%10s%10s%10s%10s%10s", "DATA", "ENTRADA", "SAIDA", "ENTRADA", "SAIDA"));

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		List<String> registrosPonto = folhaPonto.getRegistrosPontos().keySet().stream()
				.map(x -> LocalDate.parse(x, formatter))
				.sorted()
				.map(x -> formatter.format(x))
				.collect(Collectors.toList());

		for (String dataRegistroPonto : registrosPonto) {
			writer.append(String.format("\n%s", dataRegistroPonto));

			List<String> registros = folhaPonto.getRegistrosPontos().get(dataRegistroPonto).stream()
					.map(x -> LocalTime.parse(x))
					.sorted()
					.map(String::valueOf)
					.collect(Collectors.toList());

			for (String registro : registros) {
				writer.append(String.format("%10s", registro));
			}
		}

		System.out.println(writer.toString());
	}

	private void imprimeCabecalho() {
		System.out.print(String.format("SISTEMA INTEGRADO: XPTO \t\t\t\t DATA: %s\n",
				new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
		System.out.print(String.format("MÓDULO: RH \t\t\t\t\t\t HORA: %s\n",
				new SimpleDateFormat("HH:MM").format(new Date())));
		System.out.print(String.format("\t\t\t\tFOLHA DE PONTO\n"));
	}

	private void imprimeRodape() {
		System.out.print(String.format("\n\t\t\t\t\t\t\t  Código de Autenticação: %s\n", "fkyew6868fewjfhjjewf"));
	}
}
