package com.mhp.solutions.tiny.ecommerce.repository;

import com.mhp.solutions.tiny.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepo extends JpaRepository<Category,Long> {
    @Query("select case when count(c)> 0 then true else false end from Category c where c.categoryName = ?1")
    boolean existsCategoryByName(String name);
    Category findCategoriesByCategoryName(String name);
}
