package com.codegym.repositories;

import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
//    Page<Category> findAllByCategory_name(String category_name, Pageable pageable);
}
