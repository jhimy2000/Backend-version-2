package com.merkadeam.market.domain.service;

import com.merkadeam.market.domain.Category;
import com.merkadeam.market.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll()
    {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int categoryId){
        return categoryRepository.getCategory(categoryId);
    }

    public Category save(Category category)
    {
        return categoryRepository.save(category);
    }
    public boolean delete(int categoryId)
    {
        return getCategory(categoryId).map(category -> {
            categoryRepository.delete(categoryId);
            return true;
        }).orElse(false);
    }
}
