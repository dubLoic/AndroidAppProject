package fr.epsi.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import fr.epsi.entity.Category;

public class CategoryServiceImplementation implements CategoryService {

    @Override
    public Category getCategory(String p_json, String id) {
        try {
            JSONObject jsonObject = new JSONObject(p_json);
            JSONArray jsonItems = jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonItems.length(); i++) {
                if (jsonItems.getJSONObject(i).optString("category_id") == id)
                    return new Category(jsonItems.getJSONObject(i));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Category> getCategories(String p_json) {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(p_json);
            JSONArray jsonItems = jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonItems.length(); i++) {
                Category category = new Category(jsonItems.getJSONObject(i));
                categories.add(category);
            }
            return categories;
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
