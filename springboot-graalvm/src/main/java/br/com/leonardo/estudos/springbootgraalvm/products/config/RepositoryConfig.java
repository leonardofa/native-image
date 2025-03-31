package br.com.leonardo.estudos.springbootgraalvm.products.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@Configuration
public class RepositoryConfig {

  @Bean
  public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator(ObjectMapper objectMapper) {
    Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
    factory.setMapper(objectMapper);
    factory.setResources(new Resource[]{new ClassPathResource("products-data.json")});
    return factory;
  }

}
