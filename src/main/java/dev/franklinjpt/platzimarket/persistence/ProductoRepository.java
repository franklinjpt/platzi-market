package dev.franklinjpt.platzimarket.persistence;

import dev.franklinjpt.platzimarket.domain.Product;
import dev.franklinjpt.platzimarket.domain.repository.ProductRepository;
import dev.franklinjpt.platzimarket.persistence.crud.ProductoCrudRepository;
import dev.franklinjpt.platzimarket.persistence.entity.Producto;
import dev.franklinjpt.platzimarket.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;

    @Autowired
    public ProductoRepository(ProductoCrudRepository productoCrudRepository, ProductMapper mapper) {
        this.productoCrudRepository = productoCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<Product>> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getByPriceAndStatus(double price) {
        List<Producto> productos = productoCrudRepository.findByPrecioVentaGreaterThanAndEstado(price, true);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<Product> getProduct(long productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product saveProduct(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(long productId) {
        productoCrudRepository.deleteById(productId);
    }
}
