package com.MyDodaDEv.ma.repository;


import com.MyDodaDEv.ma.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Amemorte //KOISONN MANES MANA
 * @since 28/05/2022
 * @version 1
 */
@Repository
public interface CategorieRepo extends JpaRepository<Categorie,Long> {
    @Query("SELECT a FROM Categorie a WHERE trim(lower(a.libelle)) =trim(lower(?1)) ")
    Optional<Categorie> findCategorieByLibelle(String libelle);
}
