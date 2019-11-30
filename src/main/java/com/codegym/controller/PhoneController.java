package com.codegym.controller;

import com.codegym.model.Phone;
import com.codegym.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class PhoneController {
    @Autowired
    PhoneService phoneService;
//    @GetMapping("/phone")
//    public ModelAndView listPhones(@PageableDefault(size = 5, sort = "price") Pageable pageable){
//        Page<Phone>phones = phoneService.findAll(pageable);
//        ModelAndView modelAndView = new ModelAndView("phone/list");
//        modelAndView.addObject("phones", phones);
//        return modelAndView;
//    }

    @GetMapping("/phone-create")
    public ModelAndView createPhone(){
        ModelAndView modelAndView = new ModelAndView("phone/create");
        modelAndView.addObject("phones",new Phone());
        return modelAndView;
    }

    @PostMapping("/phone-create")
    public ModelAndView save(@ModelAttribute("phones") Phone phone){
        phoneService.save(phone);
        ModelAndView modelAndView = new ModelAndView("phone/create");
        modelAndView.addObject("phones", new Phone());
        modelAndView.addObject("message","created new Phone in Phone list");
        return modelAndView;
    }

    @GetMapping("/phone-edit/{id}")
    public ModelAndView editForm(@PathVariable Long id){
        Phone phone = phoneService.findById(id);
        if(phone != null){
            ModelAndView modelAndView = new ModelAndView("phone/edit");
            modelAndView.addObject("phones", phone);
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView("error/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/phone-edit")
    public ModelAndView update(@ModelAttribute("phones") Phone phone){
        phoneService.save(phone);
        ModelAndView modelAndView = new ModelAndView("phone/edit");
        modelAndView.addObject("phones", new Phone());
        modelAndView.addObject("message","Edited this information phone");
        return modelAndView;
    }

    @GetMapping("/phone-delete/{id}")
    public ModelAndView deleteForm(@PathVariable Long id){
        Phone phone = phoneService.findById(id);
        if(phone != null){
            ModelAndView modelAndView = new ModelAndView("phone/delete");
            modelAndView.addObject("phones", phone);
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView("error/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/phone-delete")
    public String remove(@ModelAttribute("phones") Phone phone){
        phoneService.remove(phone.getId());
        return "redirect:phone";
    }

    @GetMapping("/phone-detail/{id}")
    public ModelAndView detail(@PathVariable Long id){
        Phone phone = phoneService.findById(id);
        if(phone != null){
            ModelAndView modelAndView = new ModelAndView("phone/detail");
            modelAndView.addObject("phones", phone);
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView("error/error.404");
            return modelAndView;
        }
    }
    @GetMapping("/phone")
    public ModelAndView listPhones(@RequestParam("s") Optional<String> s, @PageableDefault(size = 5, sort = "price") Pageable pageable){
        Page<Phone> phones;
        if (s.isPresent()){
            phones = phoneService.findAllByNameContaining(s.get(),pageable);
        } else {
            phones = phoneService.findAll(pageable);
        }

        ModelAndView modelAndView = new ModelAndView("phone/list");
        modelAndView.addObject("phones", phones);
        return modelAndView;
    }
}