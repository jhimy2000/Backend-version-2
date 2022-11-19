package com.merkadeam.market.domain.repository;

import com.merkadeam.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    //en etsa claes vamos a indicar el nombr dde lso metodos que queremos que cuqien re q quiera trabajr tienes qye implementar
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);

    Optional<Product> getProduct (int productId);
    Product save(Product product);
    void  delete(int productId);
}
