package fr.epsi.entity;

import org.json.JSONObject;

public class Produit {
    private String name;
    private String description;
    private String picture_url;

    public Produit(JSONObject o){
        this.setName(o.optString("name",""));
        this.setDescription(o.optString("description",""));
        this.setPicture_url(o.optString("picture_url",""));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }
}
