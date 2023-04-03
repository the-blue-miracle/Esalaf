8package com.exemple.model;


// java beans (Entity)
public class Produit {

    private Long id_produit ;

    private String nom ;

    public Produit() {
    }

    public Produit(Long id_produit, String nom) {
        this.id_produit = id_produit;
        this.nom = nom;
    }

    public Long getId_produit() {
        return id_produit;
    }

    public void setId_produit(Long id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id_produit=" + id_produit +
                ", nom='" + nom + '\'' +
                '}';
    }
}
