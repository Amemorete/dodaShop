package com.MyDodaDEv.ma.serviceimpl;


import com.MyDodaDEv.ma.entities.Categorie;
import com.MyDodaDEv.ma.exceptions.Exceptions;
import com.MyDodaDEv.ma.repository.CategorieRepo;
import com.MyDodaDEv.ma.serviceinterface.CategorieInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * @author Amemorte //KOISONN MANES MANA
 * @since 28/05/2022
 * @version 1
 */

@Service
@Transactional
public class CategorieImpl implements CategorieInterface {
    @Autowired
    private CategorieRepo categorieRepo;


    @Override
    public List<Categorie> getCategorie() {
        return categorieRepo.findAll();
    }

    @Override
    public void addNewCategorie(Categorie categorie) throws Exceptions {
        categorieRepo.save(categorie);
    }

    @Override
    public void deleteCategorie(Long categorieId) throws Exceptions {
        boolean exists = categorieRepo.existsById(categorieId);
        if(!exists)
            throw  new Exceptions(Exceptions.alertGeneralException("agr dont l id "+categorieId+"n'existe pas "));

        categorieRepo.deleteById(categorieId);

    }

    @Override
    public void updateCategorie(Long id, Categorie categorie) throws Exceptions {
        if(!isPresent(categorie.getId()))
            throw new Exceptions(Exceptions.alertGeneralException("l'identifiant n'esiste pas"));
        Categorie categorie1=getById(categorie.getId());

        categorie1.setLibelle(categorie.getLibelle());


        categorie=categorieRepo.save(categorie1);

        if (categorie==null){
            throw new Exceptions(Exceptions.alertGeneralException("echoué"));
        }

    }

    @Override
    public Categorie getById(Long id) throws Exceptions {
        if(!isPresent(id))
            throw new Exceptions(Exceptions.alertGeneralException("l'identifiant n'existe pas"));
        Optional<Categorie> opad=categorieRepo.findById(id);
        return  opad.get();
    }

    public boolean isPresent(String libelle){
        Optional<Categorie> opab=categorieRepo.findCategorieByLibelle(libelle);
        if (opab.isPresent())
            return true;
        return false;
    }
    public boolean isPresent(Long id){
        Optional<Categorie> opab=categorieRepo.findById(id);
        if (opab.isPresent())
            return true;
        return false;
    }
}
