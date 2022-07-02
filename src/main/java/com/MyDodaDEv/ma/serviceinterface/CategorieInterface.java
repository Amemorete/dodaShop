package com.MyDodaDEv.ma.serviceinterface;


import com.MyDodaDEv.ma.entities.Categorie;
import com.MyDodaDEv.ma.exceptions.Exceptions;

import java.util.List;

/**
 * @author Amemorte //KOISONN MANES MANA
 * @since 28/05/2022
 * @version 1
 */

public interface CategorieInterface {
    /**
     * Liste des cours
     * @return
     */
    List<Categorie> getCategorie();

    /**
     * creation d'une categorie
     * @param categorie
     */
    public void addNewCategorie(Categorie categorie) throws Exceptions;

    /**
     * supprimer un categorie
     * @param categorieId
     */
    void deleteCategorie(Long categorieId) throws Exceptions;

    public void updateCategorie(Long id, Categorie categorie)throws Exceptions;

    public Categorie getById(Long id) throws  Exceptions;

}
