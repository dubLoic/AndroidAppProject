package fr.epsi.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import fr.epsi.entity.Product;

public class ProductServiceImplementation implements ProductService {

    @Override
    public Product getProduct(String p_json, String name) {
        try {
            JSONObject jsonObject = new JSONObject(p_json);
            JSONArray jsonItems = jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonItems.length(); i++) {
                if (jsonItems.getJSONObject(i).optString("name") == name)
                    return new Product(jsonItems.getJSONObject(i));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Product> getProducts(String p_json) {
        ArrayList<Product> products = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(p_json);
            JSONArray jsonItems = jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonItems.length(); i++) {
                Product etudiant = new Product(jsonItems.getJSONObject(i));
                products.add(etudiant);
            }
            return products;
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
