package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.repositories.CategoryRepository;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public ModelAndView categoryList(@PageableDefault (size = 5) Pageable pageable) {
//        Iterable<Category> categories = categoryService.findAll();
        Page<Category> categories = categoryService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("category/list");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/category-create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("categories", new Category());
        return modelAndView;
    }

    @PostMapping("/category-create")
    public ModelAndView create(@ModelAttribute("categories") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("categories", new Category());
        modelAndView.addObject("message", "Created new, thank you so much!");
        return modelAndView;
    }

    @GetMapping("/category-edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("category/edit");
            modelAndView.addObject("categories", category);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/category-edit")
    public ModelAndView edit(@ModelAttribute ("categories") Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/edit");
        modelAndView.addObject("categories", new Category());
        modelAndView.addObject("message","Edited this category");
        return modelAndView;
    }

    @GetMapping("/category-delete/{id}")
    public ModelAndView deleteForm(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("category/delete");
            modelAndView.addObject("categories", category);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/category-delete")
    public String delete(@ModelAttribute("categories") Category category){
        categoryService.remove(category.getCategory_Id());
        return "redirect:category";
    }
    @GetMapping("/category-detail/{id}")
    public ModelAndView detail(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("category/detail");
            modelAndView.addObject("categories", category);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error/error.404");
            return modelAndView;
        }
    }


//    @GetMapping("/category")
//    public ModelAndView listMaterials(@RequestParam("s") Optional<String> s, Pageable pageable){
//        Page<Category> categories;
//        if(s.isPresent()){
//            categories = categoryService.findAllByCategory_name(s.get(), pageable);
//        } else {
//            categories = categoryService.findAll(pageable);
//        }
//        ModelAndView modelAndView = new ModelAndView("category/list");
//        modelAndView.addObject("categories", categories);
//        return modelAndView;
//    }
}