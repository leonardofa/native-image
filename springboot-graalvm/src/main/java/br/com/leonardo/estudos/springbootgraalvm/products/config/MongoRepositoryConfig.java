package br.com.leonardo.estudos.springbootgraalvm.products.config;

import br.com.leonardo.estudos.springbootgraalvm.products.model.Product;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

import java.util.UUID;

@Profile("mongodb")
@Configuration
public class MongoRepositoryConfig {

  @Bean
  public AbstractMongoEventListener<Product> idListener() {
    return new AbstractMongoEventListener<Product>() {
      @Override
      public void onBeforeConvert(BeforeConvertEvent<Product> event) {
        val product = event.getSource();
        product.setId(UUID.randomUUID());
      }
    };
  }

}
