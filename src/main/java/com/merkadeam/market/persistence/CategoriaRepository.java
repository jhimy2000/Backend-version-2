package com.merkadeam.market.persistence;

import com.merkadeam.market.domain.Category;
import com.merkadeam.market.domain.Product;
import com.merkadeam.market.domain.repository.CategoryRepository;
import com.merkadeam.market.persistence.crud.CategoriaCrudRepository;
import com.merkadeam.market.persistence.entity.Categoria;
import com.merkadeam.market.persistence.entity.Producto;
import com.merkadeam.market.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements CategoryRepository {
    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;

    @Autowired
    private CategoryMapper mapper;

    @Override
    public List<Category> getAll()
    {
        List<Categoria> categorias=(List<Categoria>) categoriaCrudRepository.findAll();
        return mapper.toCategories(categorias);
    }

    @Override
    public void delete(int categoriaId)
    {
        categoriaCrudRepository.deleteById(categoriaId);
    }

    @Override
    public Category save(Category category) {
        Categoria categoria=mapper.toCategoria(category);
        return mapper.toCategory(categoriaCrudRepository.save(categoria));
    }

    @Override
    public Optional<Category> getCategory(int categoryId) {
        return categoriaCrudRepository.findById(categoryId).map(categoria -> mapper.toCategory(categoria));
    }






}
