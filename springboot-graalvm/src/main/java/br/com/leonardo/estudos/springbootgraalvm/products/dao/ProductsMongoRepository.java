package br.com.leonardo.estudos.springbootgraalvm.products.dao;

import br.com.leonardo.estudos.springbootgraalvm.products.model.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

@Profile("mongodb")
public interface ProductsMongoRepository extends MongoRepository<Product, UUID> {
}
