package br.com.leonardo.estudos.springbootgraalvm.products.dao;

import br.com.leonardo.estudos.springbootgraalvm.products.model.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

@Profile("h2")
public interface ProductsH2Repository extends CrudRepository<Product, UUID> {
}
