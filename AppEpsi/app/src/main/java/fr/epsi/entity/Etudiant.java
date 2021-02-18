package fr.epsi.entity;

import org.json.JSONObject;

public class Etudiant {
    private String name;
    private String email;
    private String url;

    public Etudiant(JSONObject o){
        this.setName(o.optString("name",""));
        this.setEmail(o.optString("email",""));
        this.setUrl(o.optString("picture_url",""));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
