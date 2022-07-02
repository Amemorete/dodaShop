package com.MyDodaDEv.ma.serviceimpl;

import com.MyDodaDEv.ma.entities.Produit;
import com.MyDodaDEv.ma.exceptions.Exceptions;
import com.MyDodaDEv.ma.repository.ProduitRepo;
import com.MyDodaDEv.ma.serviceinterface.ProduitInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitImpl implements ProduitInterface {
    @Autowired
    ProduitRepo produitRepo;

    @Override
    public List<Produit> getProduit() {
        return produitRepo.findAll();
    }

    @Override
    public Produit addNewProduit(Produit produit) throws Exceptions {
        produitRepo.save(produit);

        return produit;
    }

    @Override
    public void deleteProduit(Long produitId) throws Exceptions {
        boolean exists = produitRepo.existsById(produitId);
        if(!exists)
            throw  new Exceptions(Exceptions.alertGeneralException("agr dont l id "+produitId+"n'existe pas "));

        produitRepo.deleteById(produitId);

    }

    @Override
    public Produit updateProduit(Long id, Produit produit) throws Exceptions {
        if(!isPresent(produit.getId()))
            throw new Exceptions(Exceptions.alertGeneralException("l'identifiant n'esiste pas"));
        Produit produit1=getById(produit.getId());

        produit1.setPhoto1(produit.getPhoto1());
        produit1.setPhoto2(produit.getPhoto2());
        produit1.setPhoto3(produit.getPhoto3());
        produit1.setPhoto3(produit.getPhoto3());
        produit1.setPhoto4(produit.getPhoto4());
        produit1.setCategorie(produit.getCategorie());
        produit1.setDescription(produit.getDescription());
        produit1.setLibelle(produit.getLibelle());

        Produit produit2=produitRepo.save(produit);

        if (produit2==null){
            throw new Exceptions(Exceptions.alertGeneralException("echoué"));
        }

        return produit1;
    }

    @Override
    public Produit getById(Long id) throws Exceptions {
        if(!isPresent(id))
            throw new Exceptions(Exceptions.alertGeneralException("l'identifiant n'existe pas"));
        Optional<Produit> opad=produitRepo.findById(id);
        return  opad.get();
    }


    public boolean isPresent(Long id){
        Optional<Produit> opab=produitRepo.findById(id);
        if (opab.isPresent())
            return true;
        return false;
    }
}
