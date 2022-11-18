package dev.franklinjpt.platzimarket.domain.repository;

import dev.franklinjpt.platzimarket.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Optional<List<Product>> getAll();
    Optional<List<Product>> getByPriceAndStatus(double price);
    Optional<Product> getProduct(long productId);
    Product saveProduct(Product product);
    void delete(long productId);

}
