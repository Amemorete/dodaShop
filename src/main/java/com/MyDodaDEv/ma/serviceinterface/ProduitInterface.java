package com.MyDodaDEv.ma.serviceinterface;


import com.MyDodaDEv.ma.entities.Produit;
import com.MyDodaDEv.ma.exceptions.Exceptions;

import java.util.List;

public interface ProduitInterface {
    /**
     * Liste des cours
     * @return
     */
    List<Produit> getProduit();

    /**
     * creation d'un  produit
     * @param  produit
     * @return
     */
    public Produit addNewProduit(Produit  produit) throws Exceptions;

    /**
     * supprimer un categorie
     * @param  produitId
     */
    void deleteProduit(Long  produitId) throws Exceptions;

    public Produit updateProduit(Long id, Produit  produit)throws Exceptions;

    public  Produit getById(Long id) throws  Exceptions;

}
