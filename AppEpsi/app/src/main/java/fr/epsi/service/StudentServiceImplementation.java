package fr.epsi.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import fr.epsi.entity.Data;
import fr.epsi.entity.Student;

public class StudentServiceImplementation implements StudentService {
    @Override
    public Student getEtudiant(String name) {
        try {
            JSONObject jsonObject = new JSONObject(Data.allData);
            JSONArray jsonItems = jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonItems.length(); i++) {
                if (jsonItems.getJSONObject(i).optString("name") == name)
                    return new Student(jsonItems.getJSONObject(i));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Student> getEtudiants() {
        ArrayList<Student> etudiants = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(Data.allData);
            JSONArray jsonItems = jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonItems.length(); i++) {
                Student etudiant = new Student(jsonItems.getJSONObject(i));
                etudiants.add(etudiant);
            }
            return etudiants;
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
