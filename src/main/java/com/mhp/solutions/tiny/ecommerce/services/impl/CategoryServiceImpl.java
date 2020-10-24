package com.mhp.solutions.tiny.ecommerce.services.impl;

import com.mhp.solutions.tiny.ecommerce.config.ObjectMapperUtils;
import com.mhp.solutions.tiny.ecommerce.entities.Category;
import com.mhp.solutions.tiny.ecommerce.entities.dto.CategoryDto;
import com.mhp.solutions.tiny.ecommerce.repository.CategoryRepo;
import com.mhp.solutions.tiny.ecommerce.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public CategoryDto getCategoryByName(String category) {
        CategoryDto categoryDto = new CategoryDto();
        Category entity = categoryRepo.findCategoriesByCategoryName(category);
        if(entity!=null) {
            categoryDto = ObjectMapperUtils.map(entity, CategoryDto.class);
        }
        return categoryDto;
    }


    @Override
    public void addCategory(CategoryDto categoryDto) {
        final Category entity = ObjectMapperUtils.map(categoryDto, Category.class);
        categoryRepo.save(entity);
        categoryDto.setId(entity.getId());
    }

    @Override
    public void updateCategory(CategoryDto categoryDto) {
        final Category entity = ObjectMapperUtils.map(categoryDto, Category.class);
        categoryRepo.save(entity);
        categoryDto.setId(entity.getId());
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        categoryRepo.deleteById(categoryId);
    }

    @Override
    public Boolean existsInDb(String categoryName) {
        return categoryRepo.existsCategoryByName(categoryName);
    }
}
