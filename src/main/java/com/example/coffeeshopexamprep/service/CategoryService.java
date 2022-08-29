package com.example.coffeeshopexamprep.service;

import com.example.coffeeshopexamprep.model.entity.Category;
import com.example.coffeeshopexamprep.model.entity.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
