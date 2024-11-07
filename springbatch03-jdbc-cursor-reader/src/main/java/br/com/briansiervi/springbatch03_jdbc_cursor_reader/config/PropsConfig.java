package br.com.briansiervi.springbatch03_jdbc_cursor_reader.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class PropsConfig {
  @Bean
  PropertySourcesPlaceholderConfigurer config() {
    PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
    configurer.setLocation(
        new FileSystemResource(
            "/home/brian/Documentos/workspace/spring-batch/springbatch03-jdbc-cursor-reader/application.properties"));
    return configurer;
  }
}
