package dev.franklinjpt.platzimarket.persistence.crud;

import dev.franklinjpt.platzimarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoCrudRepository extends CrudRepository<Producto, Long> {

    List<Producto> findByPrecioVentaGreaterThanAndEstado(Double precioVenta, boolean estado);
}
