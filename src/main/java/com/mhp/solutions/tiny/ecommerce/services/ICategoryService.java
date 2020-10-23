package com.mhp.solutions.tiny.ecommerce.services;

import com.mhp.solutions.tiny.ecommerce.entities.Category;
import com.mhp.solutions.tiny.ecommerce.entities.dto.CategoryDto;

public interface ICategoryService {
    CategoryDto getCategoryByName(String category);
    void addCategory(CategoryDto categoryDto);
    void updateCategory(CategoryDto categoryDto);
    void deleteCategoryById(Long categoryId);
    Boolean existsInDb(String categoryName);
}
