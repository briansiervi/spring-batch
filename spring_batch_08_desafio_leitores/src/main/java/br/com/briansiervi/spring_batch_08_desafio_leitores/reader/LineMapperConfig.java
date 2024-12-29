package br.com.briansiervi.spring_batch_08_desafio_leitores.reader;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.briansiervi.spring_batch_08_desafio_leitores.dominio.Arquivo;

@Configuration
public class LineMapperConfig {

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Bean
  PatternMatchingCompositeLineMapper lineMapper() {
    PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper<>();
    lineMapper.setTokenizers(tokenizers());
    lineMapper.setFieldSetMappers(fieldSetMappers());
    return lineMapper;
  }

  private Map<String, LineTokenizer> tokenizers() {
    Map<String, LineTokenizer> tokenizers = new HashMap<>();
    tokenizers.put("*", arquivoTokenizer());
    return tokenizers;
  }

  @SuppressWarnings("rawtypes")
  private Map<String, FieldSetMapper> fieldSetMappers() {
    Map<String, FieldSetMapper> fieldSetMappers = new HashMap<>();
    fieldSetMappers.put("*", fieldSetMapper(Arquivo.class));
    return fieldSetMappers;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  private FieldSetMapper fieldSetMapper(Class classe) {
    BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper<>();
    fieldSetMapper.setTargetType(classe);
    return fieldSetMapper;
  }

  @SuppressWarnings("static-access")
  private LineTokenizer arquivoTokenizer() {
    DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
    lineTokenizer.setDelimiter(lineTokenizer.DELIMITER_COMMA);
    lineTokenizer.setNames("id", "nomeLancamento", "nomeItem", "data", "valor");
    return lineTokenizer;
  }
}
