package com.MyDodaDEv.ma.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@ToString
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false)
    private int quantite;


    @Column(nullable = false)
    private Double prixUnitaire;


    @Column(nullable = false)
    private String description;


    @Column(nullable = false)
    private String photo1;

    @Column(nullable = false)
    private String photo2;

    @Column(nullable = false)
    private String photo3;
    @Column(nullable = false)
    private String photo4;

    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;


    @CreationTimestamp()
    private Date dateCreate;


    @UpdateTimestamp()
    @Column(nullable = false)
    private Date dateUpdate;

    @Transient
    public String getPhoto1ImagePath() {
        if(photo1==null)
            return null;
        return "produit-image/"+id+"/" +photo1;
    }
    @Transient
    public String getPhoto2ImagePath() {
        if(photo2==null)
            return null;
        return "produit-image/"+id+"/" +photo2;
    }
    @Transient
    public String getPhoto3ImagePath() {
        if(photo3==null)
            return null;
        return "produit-image/"+id+"/" +photo3;
    }
    @Transient
    public String getPhoto4ImagePath() {
        if(photo4==null)
            return null;
        return "produit-image/"+id+"/" +photo4;
    }

    public Produit() {
    }

    public Produit(Long id, String libelle, int quantite, Double prixUnitaire,
                   String description, String photo1, String photo2, String photo3,
                   String photo4, Categorie categorie, Date dateCreate, Date dateUpdate) {
        this.id = id;
        this.libelle = libelle;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.description = description;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.photo3 = photo3;
        this.photo4 = photo4;
        this.categorie = categorie;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getPhoto3() {
        return photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    public String getPhoto4() {
        return photo4;
    }

    public void setPhoto4(String photo4) {
        this.photo4 = photo4;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", quantite=" + quantite +
                ", prixUnitaire=" + prixUnitaire +
                ", description='" + description + '\'' +
                ", photo1='" + photo1 + '\'' +
                ", photo2='" + photo2 + '\'' +
                ", photo3='" + photo3 + '\'' +
                ", photo4='" + photo4 + '\'' +
                ", categorie=" + categorie +
                ", dateCreate=" + dateCreate +
                ", dateUpdate=" + dateUpdate +
                '}';
    }
}
