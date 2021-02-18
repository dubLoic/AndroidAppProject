package fr.epsi.service;

import java.util.ArrayList;

import fr.epsi.entity.Produit;

public interface ProduitService {
    Produit getProduit(String path, String name);
    ArrayList<Produit> getProduits(String path);
}
