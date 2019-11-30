package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.model.Phone;
import com.codegym.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PhoneService {

    Phone findById(Long id);

    void save(Phone phone);

    void remove(Long id);

    Page<Phone> findAll(Pageable pageable);

    Iterable<Phone> findAllByCategory(Category category);

    Page<Phone> findAllByNameContaining(String name, Pageable pageable);
}
