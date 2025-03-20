package br.com.leonardo.estudos.springbootgraalvm.products.dao;

import br.com.leonardo.estudos.springbootgraalvm.products.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Product, Long> {
}
