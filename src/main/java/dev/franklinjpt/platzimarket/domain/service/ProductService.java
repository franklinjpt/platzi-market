package dev.franklinjpt.platzimarket.domain.service;

import dev.franklinjpt.platzimarket.domain.Product;
import dev.franklinjpt.platzimarket.domain.repository.ProductRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<List<Product>> getAll() {
        return productRepository.getAll();
    }

    public Optional<List<Product>> getByPriceAndStatus(double price) {
        return productRepository.getByPriceAndStatus(price);
    }

    public Optional<Product> getProduct(long productId) {
        return productRepository.getProduct(productId);
    }

    public Product saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }

    public boolean delete(long productId) {
        try {
            productRepository.delete(productId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
