package com.MyDodaDEv.ma.controller;

import com.MyDodaDEv.ma.entities.Categorie;
import com.MyDodaDEv.ma.exceptions.Exceptions;
import com.MyDodaDEv.ma.serviceimpl.CategorieImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategorieController {

    @Autowired
    private CategorieImpl categorieImpl;

    @GetMapping("/categorie")
    public String showCategorie(Model model){
        model.addAttribute("listcategories",categorieImpl.getCategorie());
        Categorie categorie = new Categorie();
        model.addAttribute("categorie", categorie);

        return  "admin/table-categorie";
    }

    @PostMapping("/saveCategorie")
    public String saveCategorie(@ModelAttribute("cours") Categorie categorie) throws Exceptions {
        categorieImpl.addNewCategorie(categorie);
        return "redirect:/categorie";
    }



    @GetMapping("/showFormUpdateCategorie/{id}")
    public String showFormUpdateCategorie(@PathVariable(value="id") Long id, Model model) throws Exceptions {
        // Get categorie from the service
        Categorie categorie=categorieImpl.getById(id);

        //set categorie as a model attribute to pre-populate the form
        model.addAttribute("categorie", categorie);
        return "admin/update_categorie";

    }
    @GetMapping("/deleteCategorie/{id}")
    public String deleteCategorie(@PathVariable (value = "id") Long id) throws Exceptions {
        // call elete categorie method
        this.categorieImpl.deleteCategorie(id);
        return "redirect:/categorie";
    }
    @PostMapping("/updateCategorie")
    public String updateCategorie(@ModelAttribute("cours") Categorie categorie) throws Exceptions {
        categorieImpl.updateCategorie(categorie.getId(),categorie);
        return "redirect:/categorie";
    }
}
