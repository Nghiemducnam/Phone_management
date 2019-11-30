package com.codegym.service.Impl;

import com.codegym.model.Category;
import com.codegym.repositories.CategoryRepository;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CategoryImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
//    @Override
//    public Iterable<Category> findAll() {
//        return categoryRepository.findAll();
//    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);

    }

    @Override
    public void remove(Long id) {
        categoryRepository.delete(id);
    }

//    @Override
//    public Page<Category> findAllByCategory_name(String category_name, Pageable pageable) {
//        return categoryRepository.findAllByCategory_name(category_name, pageable);
//    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}