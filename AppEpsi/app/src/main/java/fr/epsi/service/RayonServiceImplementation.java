package fr.epsi.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import fr.epsi.entity.Rayon;

public class RayonServiceImplementation implements RayonService {

    @Override
    public Rayon getRayon(String path, String id) {
        try {
            JSONObject jsonObject = new JSONObject(Connection.getJSONObject(path));
            JSONArray jsonItems = jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonItems.length(); i++) {
                if (jsonItems.getJSONObject(i).optString("category_id") == id)
                    return new Rayon(jsonItems.getJSONObject(i));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Rayon> getRayons(String path) {
        ArrayList<Rayon> rayons = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(Connection.getJSONObject(path));
            JSONArray jsonItems = jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonItems.length(); i++) {
                Rayon rayon = new Rayon(jsonItems.getJSONObject(i));
                rayons.add(rayon);
            }
            return rayons;
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
