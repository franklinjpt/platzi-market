package dev.franklinjpt.platzimarket.persistence.mapper;

import dev.franklinjpt.platzimarket.domain.Category;
import dev.franklinjpt.platzimarket.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "idCategoria", target = "categoryId")
    @Mapping(source = "descripcion", target = "category")
    @Mapping(source = "estado", target = "active")
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
