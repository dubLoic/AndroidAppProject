package fr.epsi.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import fr.epsi.entity.Data;
import fr.epsi.entity.Etudiant;

public class EtudiantServiceImplementation implements EtudiantService {
    @Override
    public Etudiant getEtudiant(String name) {
        try {
            JSONObject jsonObject = new JSONObject(Data.allData);
            JSONArray jsonItems = jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonItems.length(); i++) {
                if (jsonItems.getJSONObject(i).optString("name") == name)
                    return new Etudiant(jsonItems.getJSONObject(i));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Etudiant> getEtudiants() {
        ArrayList<Etudiant> etudiants = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(Data.allData);
            JSONArray jsonItems = jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonItems.length(); i++) {
                Etudiant etudiant = new Etudiant(jsonItems.getJSONObject(i));
                etudiants.add(etudiant);
            }
            return etudiants;
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
