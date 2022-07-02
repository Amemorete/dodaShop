package com.MyDodaDEv.ma.controller;

import com.MyDodaDEv.ma.constant.FileUploadUtil;
import com.MyDodaDEv.ma.entities.Categorie;
import com.MyDodaDEv.ma.entities.Produit;
import com.MyDodaDEv.ma.entities.Users;
import com.MyDodaDEv.ma.exceptions.Exceptions;
import com.MyDodaDEv.ma.serviceinterface.CategorieInterface;
import com.MyDodaDEv.ma.serviceinterface.ProduitInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class produitContrller {

    @Autowired
    ProduitInterface produitInterface;

    @Autowired
    CategorieInterface categorieInterface;

    @GetMapping("/produit")
    public String showUsers(Model model)throws Exceptions {
        List<Produit> produitList=produitInterface.getProduit();

        model.addAttribute("listproduit", produitList);

        model.addAttribute("listcategorie",categorieInterface.getCategorie());

        Produit produit = new Produit();
        model.addAttribute("produit", produit);




        return  "admin/table-produit";
    }
    @PostMapping("/saveProduit")
    public String saveProduit(@ModelAttribute("produit") Produit produit, @RequestParam("image1") MultipartFile multipartFile1,
                              @RequestParam("image2") MultipartFile multipartFile2, @RequestParam("image3") MultipartFile multipartFile3
    , @RequestParam("image4") MultipartFile multipartFile4) throws Exception {

        String fileName1= StringUtils.cleanPath(multipartFile1.getOriginalFilename());
        produit.setPhoto1(fileName1);
        String fileName2= StringUtils.cleanPath(multipartFile2.getOriginalFilename());
        produit.setPhoto2(fileName2);
        String fileName3= StringUtils.cleanPath(multipartFile3.getOriginalFilename());
        produit.setPhoto3(fileName3);
        String fileName4= StringUtils.cleanPath(multipartFile4.getOriginalFilename());
        produit.setPhoto4(fileName4);

      Produit addNewProduit=produitInterface.addNewProduit(produit);
      String uploadDIr ="produit-image/"+addNewProduit.getId();

        FileUploadUtil.saveFile(uploadDIr,fileName1,multipartFile1);
        FileUploadUtil.saveFile(uploadDIr,fileName2,multipartFile2);
        FileUploadUtil.saveFile(uploadDIr,fileName2,multipartFile2);
        FileUploadUtil.saveFile(uploadDIr,fileName2,multipartFile2);




        return "redirect:/produit";
    }
    @PostMapping("/updateProduit")
    public String updateProduit(@ModelAttribute("produit") Produit produit, @RequestParam("image1") MultipartFile multipartFile1,
                              @RequestParam("image2") MultipartFile multipartFile2, @RequestParam("image3") MultipartFile multipartFile3
            , @RequestParam("image4") MultipartFile multipartFile4) throws Exception {

        String fileName1= StringUtils.cleanPath(multipartFile1.getOriginalFilename());
        produit.setPhoto1(fileName1);
        String fileName2= StringUtils.cleanPath(multipartFile2.getOriginalFilename());
        produit.setPhoto2(fileName2);
        String fileName3= StringUtils.cleanPath(multipartFile3.getOriginalFilename());
        produit.setPhoto3(fileName3);
        String fileName4= StringUtils.cleanPath(multipartFile4.getOriginalFilename());
        produit.setPhoto4(fileName4);

        Produit updateProduit=produitInterface.updateProduit(produit.getId(),produit);
        String uploadDIr ="produit-image/"+updateProduit.getId();

        FileUploadUtil.saveFile(uploadDIr,fileName1,multipartFile1);
        FileUploadUtil.saveFile(uploadDIr,fileName2,multipartFile2);
        FileUploadUtil.saveFile(uploadDIr,fileName2,multipartFile2);
        FileUploadUtil.saveFile(uploadDIr,fileName2,multipartFile2);




        return "redirect:/produit";
    }


    @GetMapping("/formUpdateProduit/{id}")
    public String showFormUpdateProduit(@PathVariable(value="id") Long id, Model model) throws Exceptions {
        Produit produit=produitInterface.getById(id);

        model.addAttribute("listcategorie",categorieInterface.getCategorie());

        //set employee as a model attribute to pre-populate the form
        model.addAttribute("produit", produit);
        return "admin/update_produit";
    }
    @GetMapping("/deleteProduit/{id}")
    public String deleteCategorie(@PathVariable (value = "id") Long id) throws Exceptions {
        // call elete categorie method
        this.produitInterface.deleteProduit(id);
        return "redirect:/produit";
    }
}
