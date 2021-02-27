package fr.epsi.entity;

import org.json.JSONObject;

public class Student {
    private String name;
    private String email;
    private String url;
    private String group;
    private String website;

    public Student(JSONObject o){
        this.setName(o.optString("name",""));
        this.setEmail(o.optString("email",""));
        this.setUrl(o.optString("picture_url",""));
        this.setGroup(o.optString("group",""));
        this.setWebsite(o.optString("website",""));
    }

    public String getName() { return name; }

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

    public String getGroup() { return group; }

    public void setGroup(String group) { this.group = group; }

    public String getWebsite() { return website; }

    public void setWebsite(String website) { this.website = website; }

}
