package com.merkadeam.market.persistence.mapper;



import com.merkadeam.market.domain.Category;
import com.merkadeam.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria",target = "categoryId"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "descripcion",target = "description"),
    })
    Category toCategory(Categoria categoria);
    List<Category> toCategories(List<Categoria> categorias);
    //mapeo inverso
    @InheritInverseConfiguration
    Categoria toCategoria(Category category);
}
