package com.example.coffeeshopexamprep.repository;

import com.example.coffeeshopexamprep.model.entity.Category;
import com.example.coffeeshopexamprep.model.entity.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(CategoryNameEnum name);
}
