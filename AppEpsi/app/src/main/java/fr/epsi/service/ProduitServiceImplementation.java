package fr.epsi.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import fr.epsi.entity.Produit;

public class ProduitServiceImplementation implements ProduitService {

    @Override
    public Produit getProduit(String path, String name) {
        try {
            JSONObject jsonObject = new JSONObject(Connection.getJSONObject(path));
            JSONArray jsonItems = jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonItems.length(); i++) {
                if (jsonItems.getJSONObject(i).optString("name") == name)
                    return new Produit(jsonItems.getJSONObject(i));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Produit> getProduits(String path) {
        ArrayList<Produit> produits = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(Connection.getJSONObject(path));
            JSONArray jsonItems = jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonItems.length(); i++) {
                Produit etudiant = new Produit(jsonItems.getJSONObject(i));
                produits.add(etudiant);
            }
            return produits;
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
