package com.merkadeam.market.domain.repository;

import com.merkadeam.market.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    List<Category> getAll();
    void delete(int categoryId);
    Category save (Category category);
    Optional<Category> getCategory(int categoryId);

}
